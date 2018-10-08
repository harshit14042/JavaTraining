package com.training.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.beans.Customer;

public class CustomerDAOImpl implements DAO{

	private Connection conn;
	
	public CustomerDAOImpl(Connection con){
		super();
//		conn=DbConnections.getConnection(inStream);
		this.conn=con;
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
	
	@Override
	public List<Customer> getAllCustomers() throws SQLException{
		
		List<Customer> customerList=new ArrayList<>();
		
		String sql="select * from customerhv";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			
			long customerId=rs.getLong(1);
			String customerName=rs.getString(2);
			long mobileNumber=rs.getLong(3);
			
			Customer customer=new Customer(customerId, customerName, mobileNumber);
			
			customerList.add(customer);
		}
		
		return customerList;
		
	}

}
