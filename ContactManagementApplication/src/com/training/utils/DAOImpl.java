package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.training.entity.Contact;
import com.training.entity.ContactList;
import com.training.entity.Person;

public class DAOImpl implements DAO<Contact>{
	
	private Connection conn;
	
	
	
	
	public DAOImpl(Connection conn) {
		super();
		this.conn=conn;
		try {
			String sql="select max(contactid) from contactlisthv";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				ContactList.contactId=rs.getLong(1);
			}
			else{
				ContactList.contactId=0;
			}
			//System.out.println(ContactList.contactId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public int add(Contact contact) throws SQLException {
		String sql="insert into contactlisthv values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		int rowAdded=0;
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, contact.getContactId());
			pstmt.setString(2, contact.getPerson().getFirstName());
			pstmt.setString(3, contact.getPerson().getLastName());
			pstmt.setString(4, contact.getPerson().getEmail());
			pstmt.setString(5, contact.getRelation());
			rowAdded=pstmt.executeUpdate();
			sql="insert into contactnumbershv values(?,?)";
			for(long n:contact.getNumbers()){
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, contact.getContactId());
				pstmt.setLong(2, n);
				rowAdded+=pstmt.executeUpdate();
			}
				pstmt.close();
		return rowAdded;
	}

	

	@Override
	public TreeSet<Contact> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from contactlisthv order by firstname";
		PreparedStatement ps=null;
		TreeSet<Contact> contacts=new TreeSet<>();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String firstName=rs.getString("firstname");
				String lastName=rs.getString("lastname");
				String email=rs.getString("email");
				Long key=rs.getLong("contactid");
				TreeSet<Long> numbers=getNumbersById(key);
				
				String relation=rs.getString("relation");
				
				Person person=new Person(firstName, lastName, email);
				
				Contact contact=new Contact(key, person, relation, numbers);
				contacts.add(contact);
			}
				ps.close();
		return contacts;
	}

	@Override
	public int removeContact(long key) throws SQLException {
		// TODO Auto-generated method stub
		String sql1="delete from contactnumbershv where contactid=?";
		PreparedStatement ps=conn.prepareStatement(sql1);
		ps.setLong(1, key);
		int rows=ps.executeUpdate();
		
		sql1="delete from contactlisthv where contactid=?";
		ps=conn.prepareStatement(sql1);
		ps.setLong(1, key);
		rows+=ps.executeUpdate();
		ps.close();
		return rows;
		
		//return 0;
	}

	@Override
	public Contact findByPrimaryKey(long key) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from contactlisthv where contactid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setLong(1, key);
		Contact contact=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			String firstName=rs.getString("firstname");
			String lastName=rs.getString("lastname");
			String email=rs.getString("email");
			
			TreeSet<Long> numbers=getNumbersById(key);
			
			String relation=rs.getString("relation");
			
			Person person=new Person(firstName, lastName, email);
			
			contact=new Contact(key, person, relation, numbers);
		}
		ps.close();
		return contact;
	}
	
	

	@Override
	public void updateContactNumber(long prevNumber, long newNumber) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update contactnumbershv set phnumber=? where phnumber=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setLong(1, newNumber);
		ps.setLong(2, prevNumber);
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void removeContactNumber(long number) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from contactnumbershv where phnumber=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setLong(1, number);
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void addContactNumber(long id, Long number) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into contactnumbershv values(?,?)";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setLong(1, id);
		ps.setLong(2, number);
		ps.executeUpdate();
		ps.close();
	}


	@Override
	public int updateContactList(Contact contact, String propertyName, String updatedValue) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update contactlisthv set "+propertyName+"=? where contactid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, updatedValue);
		ps.setLong(2,contact.getContactId());
		int rows=ps.executeUpdate();
		ps.close();
		return rows;
	}


	@Override
	public TreeSet<Long> getNumbersById(long Id) throws SQLException {
		// TODO Auto-generated method stub
		TreeSet<Long> numbers=new TreeSet<>();
		String sql="select phnumber from contactnumbershv where contactid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setLong(1, Id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			numbers.add(rs.getLong(1));
		}
		ps.close();
		return numbers;
	}


	@Override
	public TreeSet<Long> getAllNumbers() throws SQLException {
		// TODO Auto-generated method stub
		TreeSet<Long> numberList=new TreeSet<>();
		String sql="select phnumber from contactnumbershv";
		PreparedStatement p=conn.prepareStatement(sql);
		ResultSet rs=p.executeQuery();
		while(rs.next()){
			numberList.add(rs.getLong(1));
		}
		p.close();
		return numberList;
	}


	@Override
	public TreeSet<String> getAllNames() throws SQLException {
		// TODO Auto-generated method stub
		TreeSet<String> nameList=new TreeSet<>();
		String sql="select firstname,lastname from contactListhv";
		PreparedStatement p=conn.prepareStatement(sql);
		ResultSet rs=p.executeQuery();
		while(rs.next()){
			nameList.add(rs.getString(1)+" "+rs.getString(2));
		}
		p.close();
		return nameList;
	}


	@Override
	public TreeSet<Contact> getContactsByRelation(String searchedRelation) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from contactlisthv where relation=?";
		PreparedStatement ps=null;
		TreeSet<Contact> contacts=new TreeSet<>();
			ps=conn.prepareStatement(sql);
			ps.setString(1, searchedRelation);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String firstName=rs.getString("firstname");
				String lastName=rs.getString("lastname");
				String email=rs.getString("email");
				Long key=rs.getLong("contactid");
				TreeSet<Long> numbers=getNumbersById(key);
				
				String relation=rs.getString("relation");
				
				Person person=new Person(firstName, lastName, email);
				
				Contact contact=new Contact(key, person, relation, numbers);
				contacts.add(contact);
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return contacts;
	}

}
