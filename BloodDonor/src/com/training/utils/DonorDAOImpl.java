package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.training.entity.Donor;

public class DonorDAOImpl implements DAO {
	
	
	Connection con;
	
	public DonorDAOImpl() throws Exception{
		super();
		Context ctx = new InitialContext();
		
		DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
		
		con=dataSource.getConnection();
		
		System.out.println(con);
	}

	@Override
	public int add(Donor donor) throws SQLException {
		// TODO Auto-generated method stub
		int rows=0;
		
		String sql="insert into donorhv values(?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1,donor.getId());
		ps.setString(2, donor.getName());
		ps.setString(3, donor.getBloodGroup());
		ps.setString(4, donor.getLocation());
		ps.setString(5, donor.getGender());
		ps.setInt(6, donor.getTimesDonated());
		ps.setLong(7, donor.getPhNumber());
		rows=ps.executeUpdate();
		return rows;
	}
	
	public Donor convertToDonor(ResultSet rs) throws SQLException{
		long id=rs.getLong(1);
		String name=rs.getString(2);
		String bloodGroup=rs.getString(3);
		String location=rs.getString(4);
		String gender=rs.getString(5);
		int timesDonated=rs.getInt(6);
		long phNumber=rs.getLong(7);
		
		Donor donor=new Donor(id, name, bloodGroup, location, gender, timesDonated, phNumber);
		return donor;
	}

	@Override
	public List<Donor> getAllDonors() throws SQLException {
		// TODO Auto-generated method stub
		List<Donor> donors=new ArrayList<>();
		
		String sql="select * from donorhv";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Donor donor=convertToDonor(rs);
			donors.add(donor);
		}
		
		return donors;
	}

	@Override
	public List<Donor> searchDonorByLocationAndGroup(String location,String group) throws SQLException {
		// TODO Auto-generated method stub
		List<Donor> donors=new ArrayList<>();
		String sql="select * from donorhv where location=? and bloodgroup=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, location);
		ps.setString(2, group);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Donor donor=convertToDonor(rs);
			donors.add(donor);
		}
		
		return donors;
	}

	@Override
	public List<String> searchDonorByLocation(String location) throws SQLException {
		// TODO Auto-generated method stub
		List<String> bloodGroups=new ArrayList<>();
		
		String sql="select distinct bloodgroup from donorhv where location=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, location);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			//Donor donor=convertToDonor(rs);
			bloodGroups.add(rs.getString(1));
		}
		
		return bloodGroups;
	}

	@Override
	public int updateDonor(String propertyName, String newVal, long id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update donorhv set "+propertyName+"=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, newVal);
		ps.setLong(2, id);
		int rows=0;
		rows=ps.executeUpdate();
		return rows;
	}

	@Override
	public List<String> getAllLocations() throws SQLException {
		// TODO Auto-generated method stub
		List<String> locations=new ArrayList<>();
		String sql="select distinct(location) from donorhv";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			locations.add(rs.getString(1));
		}
		return locations;
	}

}
