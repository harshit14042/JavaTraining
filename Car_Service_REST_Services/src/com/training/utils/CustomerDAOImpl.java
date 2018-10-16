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
	
	public Customer convertToCustomer(ResultSet rs) {
		Customer customer=null;
		
		
		return customer;
	}
	
	@Override
	public Customer findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer=null;
		String sql="select * from customer where regNo="+id;
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			customer=convertToCustomer(rs);
		
		return customer;
	}

	@Override
	public int updatebyId(String Id, String property, String newVal) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addById(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
