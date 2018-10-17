package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.training.entity.Car;
import com.training.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

Connection con;
	
	public CustomerDAOImpl() throws Exception {
		// TODO Auto-generated constructor stub
		super();
		Context ctx = new InitialContext();
		
		DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
		
		con=dataSource.getConnection();
		
		System.out.println(con);
	}
	
	public Customer convertToCustomer(ResultSet rs) throws SQLException {
		Customer customer=null;
		System.out.println(rs.getString("customer_id"));
		long id=Long.parseLong(rs.getString("customer_id"));
		String address=rs.getString("addr");
		String name=rs.getString("cname");
		String email=rs.getString("email");
		
		
		customer=new Customer(id, name, address, email);
		
		return customer;
	}
	
	@Override
	public Customer findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer=null;
		String sql="select * from hv_customer where customer_id="+id;
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			customer=convertToCustomer(rs);
		
		return customer;
	}

	@Override
	public int updatebyId(String id, String property, String newVal) throws SQLException {
		// TODO Auto-generated method stub
		int rowsAdded=0;
		String sql="update hv_customer set "+property+"="+newVal+" where id="+id;
		
		PreparedStatement ps=con.prepareStatement(sql);

		rowsAdded=ps.executeUpdate();
		
		return rowsAdded;
	}

	@Override
	public int add(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		int rowsAdded=0;
		String sql="insert into hv_customer values(?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setLong(1, customer.getCustomer_id());
		ps.setString(2, customer.getCname());
		ps.setString(3, customer.getAddr());
		ps.setString(4, customer.getEmail());
		
		rowsAdded=ps.executeUpdate();
		
		return rowsAdded;
	}

	@Override
	public long getNewId() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select max(customer_id) from hv_customer";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		long id=0;
		if(rs.next())
			id=rs.getLong(1);
		
		return ++id;
	}

}
