package com.training.services;

import java.util.HashMap;

import javax.jws.WebService;

import com.training.ifaces.Flight;

@WebService(endpointInterface="com.training.ifaces.Flight")
public class JetAWService implements Flight{

	String flightName="JetAirways";
	HashMap<String,Integer> flights; 
	
	public JetAWService() {
		super();
		flights=new HashMap<>();
		flights.put("Delhi|Bangalore", 3);
		flights.put("Delhi|Pune", 5);
		flights.put("Bangalore|Pune", 2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String seatAvailable(String src, String dest) {
		// TODO Auto-generated method stub
		Integer res=flights.get(src+"|"+dest);
		String flightDetails="";
		if(res!=null){
			flightDetails=flightName+" "+res;
		}
		return flightDetails;
	}
	
}
