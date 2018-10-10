package com.training.utils;

import javax.xml.ws.Endpoint;

import com.training.services.DonationRequestService;

public class MyPublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Endpoint.publish("http://localhost:5000/converter", new CurrencyConverterImpl());
		Endpoint.publish("http://localhost:8080/donor", new DonationRequestService());
		
		System.out.println("Service Running");
	}

}
