package com.training.resources;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import com.training.utils.DAO;
import com.training.utils.InsuranceDAOImpl;

@Path("insurance")
public class Insurance_Resource {

	
	DAO dao;
	Logger log;
	public Insurance_Resource() throws Exception {
		dao=new InsuranceDAOImpl();
		log=Logger.getRootLogger();
	}
	
	@GET
	@Path("getDetails/{customer_id}")
	public int getDetails(@PathParam("customer_id")String customer_id) {
		int cvg=0;
		try {
			cvg = dao.getbyId(customer_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Request made for details of the customer with customer id: "+customer_id+" at "+LocalDate.now());
		System.out.println(cvg);
		return cvg;
	}
	
}
