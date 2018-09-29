package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public Contact convertToContact(ResultSet rs) throws SQLException{
		long number=rs.getLong("number");
		String firstName=rs.getString("firstname");
		String lastName=rs.getString("lastName");
		String email=rs.getString("email");
		Person person=new Person(firstName,lastName,number,email);
		
		String relation=rs.getString("relation");
		long contactId=rs.getLong("contcatid");
		Contact contact=new Contact(contactId, person, relation);
		return contact;
	}

	@Override
	public List<Contact> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from contactshv inner join personshv on contactshv.personId=personshv.personId";
		PreparedStatement ps=null;
		List<Contact> contacts=new ArrayList<>();
		try{
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				contacts.add(convertToContact(rs));
			}
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

	@Override
	public int remove(long key) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select personId from contactshv where contactid=?";
		return 0;
	}

	@Override
	public Contact findByPrimaryKey(long key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRelation(Contact contact, String relation) {
		// TODO Auto-generated method stub
		
	}
	
}
