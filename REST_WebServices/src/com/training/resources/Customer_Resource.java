package com.training.resources;
import javax.ws.rs.core.*;

import java.util.HashMap;

import javax.ws.rs.*;
import com.training.beans.*;
import com.training.utils.CustomerDetails;

@Path("customer")
public class Customer_Resource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCustomer(){
		Customer cust=new Customer(101,"ramesh",484848);
		return Response.status(200).entity(cust.toString()).build();
	}
	
	@GET
	@Path("xmlFrmt")
	@Produces(MediaType.APPLICATION_XML)
	
	public Response getCustomerAsXML(){

		Customer cust=new Customer(102,"siri",797898);
		return Response.status(200).entity(cust).build();
}
	@GET
	@Path("jsonFrmt")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getCustomerAsJSON(){

		/*HashMap<Integer,Customer>custList=new HashMap<>();
		
		custList.put(101, new Customer(101,"mia",9986756));
		custList.put(102, new Customer(102,"lia",9986756));*/
		
		return Response.status(200).entity(CustomerDetails.getAllCustomer()).build();
	
	}	
	@GET
	@Path("findById/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response findCustomerById(@PathParam("custId")long customerId){

		Customer cust=CustomerDetails.getCustomer(customerId);
		return Response.status(200).entity(cust).build();
	
	}	
	
	@POST
	@Path("add")
	public String addCustomer(@FormParam("customerId")long customerId,@FormParam("customerName")String customerName,@FormParam("mobileNumber")long mobileNumber){
		return CustomerDetails.addCustomer(new Customer(customerId,customerName,mobileNumber));
	}
	
	@POST
	@Path("addCust/{custId}/{customeName}/{mobileNumber}")
	public String addCust(@PathParam("customerId")long customerId,@PathParam("customerName")String customerName,@PathParam("mobileNumber")long mobileNumber){
		return CustomerDetails.addCustomer(new Customer(customerId,customerName,mobileNumber));
	}
	
	@DELETE
	@Path("remove")
	public String removeCustomer(@QueryParam("custId")long key){
		return CustomerDetails.removeCustomer(key);
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCustomer(Customer cust,@QueryParam("custId")long key){
		return CustomerDetails.updateMobileNumber(cust,key);
	}
	
	@POST
	@Path("addAsJson")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addCustomer(Customer cust){
		CustomerDetails.addCustomer(cust);
		return cust.toString();
	}
	
//	@Produces(MediaType.TEXT_PLAIN)
	
	
}