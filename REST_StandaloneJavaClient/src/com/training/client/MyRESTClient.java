package com.training.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MyRESTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client=ClientBuilder.newClient();
		
		WebTarget target=client.target("http://localhost:8080/REST_WebServices/rest/");
		
		String response=target.path("quick").request().get(String.class);
		
		System.out.println(response);
		
		/*Response delResponse=target.path("customer/remove").queryParam("custId", 102).request().delete();
		
		System.out.println(delResponse.toString());*/
		
		Customer cust=new Customer(101,"Ram",4654);
		
		Response elResponse=target.path("customer/update").queryParam("custId", 101).request().put(Entity.entity(cust, MediaType.APPLICATION_JSON));
		
		System.out.println(elResponse.toString());
		
	}
}
