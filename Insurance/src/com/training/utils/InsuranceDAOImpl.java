package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Path;

import com.training.entity.Insurance;

@Path("insurance")
public class InsuranceDAOImpl implements DAO<Insurance>{

	Connection con;
	
	public InsuranceDAOImpl() throws Exception {
		super();
		Context ctx = new InitialContext();
		
		DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
		
		con=dataSource.getConnection();
		
		System.out.println(con);
	}
	
	public Insurance converToInsurance(ResultSet rs) throws SQLException {
		Insurance ins=null;
		
		long insurance_id=rs.getLong(1);
		String car_no=rs.getString(2);
		int coverage=rs.getInt(3);
		
		ins=new Insurance(insurance_id, car_no, coverage);
		
		return ins;
	}
	
	@Override
	public Insurance getbyId(String carNo) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from hv_insurance_details where car_no="+carNo;
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		Insurance ins=null;
		
		if(rs.next()) {
			ins=converToInsurance(rs);
		}
		return ins;
		
	}

	
	
	
}
