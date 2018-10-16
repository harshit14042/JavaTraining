package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.training.entity.Car;

public class CarDAOImpl implements DAO<Car> {

	Connection con;
	
	public CarDAOImpl() throws Exception {
		// TODO Auto-generated constructor stub
		super();
		Context ctx = new InitialContext();
		
		DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
		
		con=dataSource.getConnection();
		
		System.out.println(con);
	}
	
	public Car convertToCar(ResultSet rs) {
		Car car=null;
		
		
		return car;
	}
	
	@Override
	public Car findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Car car=null;
		String sql="select * from car where regNo="+id;
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			car=convertToCar(rs);
		
		return car;
	}

	@Override
	public int addById(Car t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
