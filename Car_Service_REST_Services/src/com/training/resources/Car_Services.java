package com.training.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.training.entity.Car;
import com.training.entity.Customer;
import com.training.utils.CarDAOImpl;
import com.training.utils.CustomerDAO;
import com.training.utils.CustomerDAOImpl;
import com.training.utils.DAO;

@Path("carservice")
public class Car_Services {
	
	DAO carDao;
	CustomerDAO custDao;
	
	public Car_Services() throws Exception {
		carDao=new CarDAOImpl();
		custDao=new CustomerDAOImpl();
	}

	@GET
	@Path("getCustomer/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerDetails(@PathParam("custId")String custId) throws SQLException {
		return custDao.findById(custId).toString();
	}
	
	@POST
	@Path("addCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	public int addCustomerDetails(Customer customer) throws SQLException {
		return custDao.addById(customer);
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
		return carDao.addById(car);
	}
	
	@GET
	@Path("getCar/{carId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCarDetails(@PathParam("carId")String carId) throws SQLException {
		return carDao.findById(carId).toString();
	}
	
}
