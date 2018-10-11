package com.training.apps;

import javax.xml.ws.Endpoint;

import com.training.services.SpiceAWService;

public class Publish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:8080/spice",new SpiceAWService());
		
		System.out.println("Spice Published");
	}

}
