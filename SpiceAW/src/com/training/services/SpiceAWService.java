package com.training.services;

import java.util.HashMap;

import javax.jws.WebService;

import com.training.ifaces.Flight;

@WebService(endpointInterface="com.training.ifaces.Flight")
public class SpiceAWService implements Flight {

	HashMap<String,Integer> flights;
	String flightName="Spice Airways";
	
	public SpiceAWService() {
		super();
		flights=new HashMap<>();
		flights.put("Delhi|Bangalore", 1);
		flights.put("Delhi|Pune", 1);
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
