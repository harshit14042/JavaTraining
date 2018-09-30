package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.training.entity.Contact;
import com.training.entity.Person;

public class ContactDAOImplementation implements ContactDAO {

	private Connection conn;
	
	
	
	
	public ContactDAOImplementation(Connection conn) {
		super();
		this.conn=conn;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(Contact contact) {
		// TODO Auto-generated method stub
		String sql="insert into contactshv values(?,?)";
		PreparedStatement pstmt=null;
		int rowAdded=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, contact.getContactId());
			pstmt.setString(2, contact.getRelation());
			rowAdded=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowAdded;
	}
	
	public TreeSet<Contact> getContacts(ResultSet rs) throws SQLException{
		Map<Person,Set<Long>> personToNumbers=new HashMap<>();
		TreeSet<Contact> contactList=new TreeSet<Contact>();
		while(rs.next()){
			long number=rs.getLong("number");
			String firstName=rs.getString("firstname");
			String lastName=rs.getString("lastName");
			String email=rs.getString("email");
			long contactId=rs.getLong("contactid");
			Set<Long> numberList=new HashSet<>();
			numberList.add(number);
			Person person=new Person(contactId,firstName, lastName, numberList, email);
			if(personToNumbers.containsKey(person)){
				Set<Long> numbers=personToNumbers.get(person);
				numbers.add(number);
				person.setNumbers(numbers);
				personToNumbers.put(person, numbers);
			}
			else{
				personToNumbers.put(person, numberList);
			}
			
			String relation=rs.getString("relation");
			
			Contact contact=new Contact(contactId, person, relation);
			contactList.add(contact);
		}
		return contactList;
	}

	@Override
	public TreeSet<Contact> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from contactshv inner join personshv on contactshv.personId=personshv.personId inner join contactnumbershv on contactnumbershv.personid=personshv.personid";
		PreparedStatement ps=null;
		TreeSet<Contact> contacts=new TreeSet<>();
		try{
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			contacts=getContacts(rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return contacts;
	}

	public int removeByPersonId(String sql,long personId) throws SQLException{
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setLong(1, personId);
		return ps.executeUpdate();
	}
	
	
	
	@Override
	public int remove(long key) throws SQLException {
		// TODO Auto-generated method stub
		String sql1="select personid from contactshv where contactid=?";
		PreparedStatement ps=conn.prepareStatement(sql1);
		ps.setLong(1, key);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			long personId=rs.getLong("personid");
			String sql="delete from personshv where personid=?";
			int rows=removeByPersonId(sql, personId);
			sql="delete from contactshv where personid=?";
			rows=removeByPersonId(sql, personId);
			sql="delete from contactnumbershv where personid=?";
			rows=removeByPersonId(sql, personId);
		}
		return 0;
	}

	@Override
	public Contact findByPrimaryKey(long key) throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void updateRelation(Contact contact, String relation) throws SQLException{
		// TODO Auto-generated method stub
		String sql="update contactshv set relation=? where contactid=?";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, relation);
		ps.setLong(2, contact.getContactId());
		ps.executeUpdate();	
		
	}
	
}
