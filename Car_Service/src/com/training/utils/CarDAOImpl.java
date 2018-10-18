package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.training.entity.Car;

public class CarDAOImpl implements GDAO<Car> {

	Connection con;
	
	public CarDAOImpl() throws Exception {
		// TODO Auto-generated constructor stub
		super();
		Context ctx = new InitialContext();
		
		DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
		
		con=dataSource.getConnection();
		
		System.out.println(con);
	}
	
	public Car convertToCar(ResultSet rs) throws SQLException {
		
		String car_no=rs.getString(1);
		long customer_id=rs.getLong(2);
		String company=rs.getString(3);
		String car_model=rs.getString(4);
		int car_age=rs.getInt(5);
		
		Car car=new Car(car_no, customer_id, company, car_model, car_age);
		
		return car;
	}
	
	@Override
	public Car findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Car car=null;
		String sql="select * from hv_car where customer_id="+id;
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			car=convertToCar(rs);
		
		return car;
	}

	@Override
	public int add(Car car) throws SQLException {
		// TODO Auto-generated method stub
		int rowsAdded=0;
		System.out.println(car);
		String sql="insert into hv_car values(?,?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,car.getCar_no());
		ps.setLong(2, car.getCustomer_id());
		ps.setString(3, car.getCompany());
		ps.setString(4, car.getCar_model());
		ps.setInt(5, car.getCar_age());
		
		rowsAdded=ps.executeUpdate();
		
		return rowsAdded;
	}

}
