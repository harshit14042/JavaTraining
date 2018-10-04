package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.beans.Customer;

public class CustomerDAOImpl implements DAO{

	private Connection conn;
	
	public CustomerDAOImpl(){
		super();
		conn=DbConnections.getConnection();
	}
	
	@Override
	public int add(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into customerhv values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setLong(1, customer.getCustomerId());
		ps.setString(2, customer.getCustomerName());
		ps.setLong(3, customer.getMobileNumber());
		int row=ps.executeUpdate();
		ps.close();
		return row;
	}

}
