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
		long customer_id=rs.getLong(2);
		String car_no=rs.getString(3);
		int coverage=rs.getInt(4);
		
		ins=new Insurance(insurance_id, car_no, customer_id, coverage);
		
		return ins;
	}
	
	@Override
	public String getbyId(String customer_id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select coverage from hv_insurance_details where customer_id="+customer_id;
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		String res="0";
		res=""+rs.getInt(1);
		return res;
		
	}

	
	
	
}
