package com.training.resources;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.training.entity.Insurance;
import com.training.utils.DAO;
import com.training.utils.InsuranceDAOImpl;

@Path("insurance")
public class Insurance_Resource {

	
	DAO dao;
	
	public Insurance_Resource() throws Exception {
		dao=new InsuranceDAOImpl();
	}
	
	@GET
	@Path("getDetails/{car_no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetails(@PathParam("car_no")String car_no) {
		Insurance ins=null;
		try {
			ins = dao.getbyId(car_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(ins).build();
	}
	
}
