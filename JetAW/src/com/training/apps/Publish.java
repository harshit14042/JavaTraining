package com.training.apps;

import javax.xml.ws.Endpoint;

import com.training.services.JetAWService;

public class Publish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:8040/jet",new JetAWService());
		
		System.out.println("Jet Published");
	}

}
