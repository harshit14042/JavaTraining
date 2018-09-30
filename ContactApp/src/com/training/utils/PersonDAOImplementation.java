package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TreeSet;

import com.training.entity.Person;

public class PersonDAOImplementation implements PersonDAO {

private Connection conn;
	public PersonDAOImplementation(Connection conn) {
		super();
		this.conn=conn;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(Person person) {
		// TODO Auto-generated method stub
		String sql="insert into personshv values(?,?,?,?)";
		PreparedStatement pstmt=null;
		int rowAdded=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, person.getId());
			pstmt.setString(2, person.getFirstName());
			pstmt.setString(3, person.getLastName());
			pstmt.setString(4, person.getEmail());
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

	@Override
	public TreeSet<Person> findAll() throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int remove(long key) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from personshv where personid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setLong(1, key);
		int rows=ps.executeUpdate();
		
		sql="delete from contacts where personid=?";
		ps=conn.prepareStatement(sql);
		ps.setLong(1, key);
		rows+=ps.executeUpdate();
		
		sql="delete from contactnumbershv where personid=?";
		ps=conn.prepareStatement(sql);
		ps.setLong(1, key);
		rows+=ps.executeUpdate();
		
		return rows;
	}

	@Override
	public Person findByPrimaryKey(long key) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	@Override
	public void updateFirstName(Person person, String firstName) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update personshv set firstname=? where personid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setString(1, firstName);
		ps.setLong(2, person.getId());
		
		ps.executeUpdate();
	}

	@Override
	public void updateLastName(Person person, String lastName) throws SQLException{
		// TODO Auto-generated method stub
		String sql="update personshv set lastname=? where personid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setString(1, lastName);
		ps.setLong(2, person.getId());
		
		ps.executeUpdate();
	}

	@Override
	public void updateEmail(Person person, String email) throws SQLException{
		// TODO Auto-generated method stub
		String sql="update personshv set email=? where personid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setString(1, email);
		ps.setLong(2, person.getId());
		
		ps.executeUpdate();
	}

	@Override
	public void addContactNumber(Person person, Long number) throws SQLException{
		// TODO Auto-generated method stub
		String sql="insert into contactnumbershv values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setLong(1, person.getId());
		ps.setLong(2, number);
		
		ps.executeUpdate();
	}
	
	@Override
	public void addContactNumber(long id, Long number) throws SQLException{
		// TODO Auto-generated method stub
		String sql="insert into contactnumbershv values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setLong(1, id);
		ps.setLong(2, number);
		
		ps.executeUpdate();
	}


	@Override
	public void updateContactNumber(Person person, long prevNumber, long newNumber) throws SQLException{
		// TODO Auto-generated method stub
		String sql="update contactnumbershv set number=? where personid=? and number=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setLong(1, newNumber);
		ps.setLong(2, person.getId());
		ps.setLong(3, prevNumber);
		
		ps.executeUpdate();
	}

	@Override
	public void removeContactNumber(Person person, long number) throws SQLException{
		// TODO Auto-generated method stub
		String sql="delete from contactnumbers where personid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		
		ps.setLong(1, person.getId());
		
		ps.executeUpdate();
	}
	
}
