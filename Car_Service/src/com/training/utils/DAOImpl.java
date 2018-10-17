package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.training.entity.Employee;

public class DAOImpl implements DAO<Employee> {

	private Connection con;
	
	
	
	public DAOImpl() throws Exception {
		super();
		Context ctx = new InitialContext();
		
		DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
		
		con=dataSource.getConnection();
		
		System.out.println(con);
		
		// TODO Auto-generated constructor stub
	}



	@Override
	public boolean validate(String userId, String passWord) throws SQLException {
		// TODO Auto-generated method stub
		boolean isValid=false;
		
		String sql="select * from hv_employee where userid=? and pass=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, userId);
		ps.setString(2, passWord);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			isValid=true;
		}
		ps.close();
		return isValid;
	}



	@Override
	public int register(String userId, String passWord) throws SQLException {
		// TODO Auto-generated method stub
		int rowsAdded=0;
		
		String sql="insert into hv_employee values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,userId);
		ps.setString(2, passWord);
		
		rowsAdded=ps.executeUpdate();
		
		return rowsAdded;
	}

}
