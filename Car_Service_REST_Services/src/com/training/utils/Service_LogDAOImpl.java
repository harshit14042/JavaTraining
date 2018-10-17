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

import com.training.entity.Service_Log;

public class Service_LogDAOImpl implements DAO<Service_Log>{

	Connection con;
	
	public Service_LogDAOImpl() throws Exception {
		super();
		Context ctx = new InitialContext();
		
		DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
		
		con=dataSource.getConnection();
		
		System.out.println(con);
	}
	
	public Service_Log convertToService_Log(ResultSet rs) throws SQLException {
		
		long sid=rs.getLong("sid");
		String car_no=rs.getString("car_no");
		String service_date=rs.getString("service_date");
		String delivery_date=rs.getString("delivery_date");
		int net_amount=rs.getInt("net_amount");
		long service_id=rs.getLong("serviceid");
		
		
		Service_Log sl=new Service_Log(sid, car_no, service_date, delivery_date, net_amount, service_id);
		return sl;
	}
	
	public List<Service_Log> findByCustId(String Id) throws SQLException {
		// TODO Auto-generated method stub
		List<Service_Log> list=new ArrayList<>();
		String sql="select * from hv_servicelog inner join hv_services on hv_servicelog.serviceid=hv_services.serviceid  inner join hv_insurance_details on hv_insurance_details.car_no=hv_servicelog.car_no inner join hv_car on hv_car.car_no=hv_servicelog.car_no where customer_id="+Id;
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			list.add(convertToService_Log(rs));
		}
		return list;
	}

	@Override
	public int add(Service_Log t) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into hv_servicelog values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setLong(1,t.getSid());
		ps.setString(2,t.getCar_no());
		ps.setString(3,t.getService_date());
		ps.setString(4,t.getDelivery_date());
		ps.setInt(5,t.getNet_amount());
		ps.setLong(6,t.getServiceid());
		
		int rowsAdded=0;
		
		rowsAdded=ps.executeUpdate();
		
		return rowsAdded;
	}

	@Override
	public Service_Log findById(String Id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
