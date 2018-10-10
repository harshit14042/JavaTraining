package com.training.resources;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.training.entity.Donor;
import com.training.utils.DAO;
import com.training.utils.DonorDAOImpl;

@Path("donor")
public class Donor_Resource {

	DAO dao;
	public Donor_Resource() throws Exception{
		dao=new DonorDAOImpl();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){		
		return "You get Configured JERSEY Property-Harshit";
	}
	
	@POST
	@Path("addDonor")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addDonor(Donor donor) throws SQLException{
		System.out.println(dao.add(donor));
		return donor.getName();
	}
	
	@GET
	@Path("allDonors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDonors() throws SQLException{
		return Response.status(200).entity(dao.getAllDonors()).build();
	}
	
	
	@GET
	@Path("locations/{location}")
	@Produces(MediaType.TEXT_HTML)
	public String getDonorsByLocation(@PathParam("location") String location) throws SQLException{
		//return Response.status(200).entity(dao.searchDonorByLocation(location)).build();
		List<String> groups=dao.searchDonorByLocation(location);
		String val="";
		for(String group:groups){
			//URI uri=UriBuilder.fromPath("locations").PathParam("location",loc).build();
			val+="<a href='http://localhost:8080/BloodDonor/rest/donor/getDonorsByGroup/"+location+"/"+group+"'>"+group+"</a><br/>";
		}
		return val;
	}
	
	@GET
	@Path("getDonorsByGroup/{location}/{group}")
	@Produces(MediaType.TEXT_HTML)
	public String getDonorsByGroup(@PathParam("location") String location,@PathParam("group") String group) throws SQLException{
		//return dao.searchDonorByLocationAndGroup(location,group).toString();
		List<Donor> donors=dao.searchDonorByLocationAndGroup(location, group);
		String val="";
		for(Donor donor:donors){
			//URI uri=UriBuilder.fromPath("locations").PathParam("location",loc).build();
			val+=donor.toString()+"<br/>";
		}
		System.out.println("Here");
		return val;

	}
	
	@PUT
	@Path("updateDonor/{propertyName}/{newValue}/{id}")
	public int updateDonor(@PathParam("propertyName") String propertyName,@PathParam("newValue") String newValue,@PathParam("id") long id) throws SQLException{
		return dao.updateDonor(propertyName, newValue, id);
	}
	
//	@GET
//	@Path("locations")
//	@Produces(MediaType.TEXT_HTML)
//	public String getDonorsByLocation() throws SQLException{
//		
//		List<String> locations=dao.getAllLocations();
//		String val="";
//		for(String loc:locations){
//			URI uri=UriBuilder.fromPath("groups").queryParam("location",loc).build();
//			val="<a href="+uri.toString()+">"+loc+"</a>";
//		}
//		return val;
//		//return Response.status(200).entity(dao.getAllLocations()).build();
//	}
	
	@GET
	@Path("locations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonorsByLocation() throws SQLException{
		return Response.status(200).entity(dao.getAllLocations()).build();
	}
}
