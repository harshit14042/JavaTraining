package com.training.resources;

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

import com.training.entity.Car;
import com.training.entity.Customer;
import com.training.entity.Service_Log;
import com.training.utils.CarDAOImpl;
import com.training.utils.CustomerDAO;
import com.training.utils.CustomerDAOImpl;
import com.training.utils.DAO;
import com.training.utils.Service_LogDAOImpl;

@Path("carservice")
public class Car_Services {
	
	DAO carDao;
	Service_LogDAOImpl serviceDao;
	CustomerDAO custDao;
	
	public Car_Services() throws Exception {
		carDao=new CarDAOImpl();
		serviceDao=new Service_LogDAOImpl();
		custDao=new CustomerDAOImpl();
	}

	@GET
	@Path("getCustomer/{customer_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerDetails(@PathParam("customer_id")String custId) throws SQLException {
		System.out.println("Called");
		Customer cust=custDao.findById(custId);
		System.out.println(cust);
		return Response.status(200).entity(cust).build();
	}
	
	@POST
	@Path("addCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	public int addCustomerDetails(Customer customer) throws SQLException {
		System.out.println("Add Customer "+customer);
		return custDao.add(customer);
	}
	
	@PUT
	@Path("updateCustomer/{custId}/{property}/{newVal}")
	public int updateCustomer(@PathParam("custId") String custId,@PathParam("property") String property,@PathParam("newVal")String newVal) throws SQLException {
		return custDao.updatebyId(custId, property, newVal);
	}
	
	@POST
	@Path("addCar")
	@Consumes(MediaType.APPLICATION_JSON)
	public int addCarDetails(Car car) throws SQLException {
		return carDao.add(car);
	}
	
	@POST
	@Path("addService")
	@Consumes(MediaType.APPLICATION_JSON)
	public int addServiceDetails(Service_Log sl) throws SQLException {
		return serviceDao.add(sl);
	}
	
	@GET
	@Path("getService/{customer_no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServiceDetails(@PathParam("customer_no")String customer_no) throws SQLException {
		List<Service_Log> list=serviceDao.findByCustId(customer_no);
		return Response.status(200).entity(list).build();
	}
	
	@GET
	@Path("getCar/{car_no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarDetails(@PathParam("car_no")String car_no) throws SQLException {
		Car car=(Car) carDao.findById(car_no);
		return Response.status(200).entity(car).build();
	}
	
	@GET
	@Path("getNewId")
	@Produces(MediaType.TEXT_PLAIN)
	public String getNewId() throws SQLException {
		String s=custDao.getNewId()+"";
		System.out.println(s);
		return s;
	}
	
}
