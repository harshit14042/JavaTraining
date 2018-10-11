package com.training.apps;

import com.training.resources.Flight;
import com.training.resources.JetAWServiceService;
import com.training.resources.SpiceAWServiceService;

public class Application {
	public static JetAWServiceService jserv;
	public static SpiceAWServiceService spiceServ;
	public static void seatAvailable(String src,String dest){
		jserv=new JetAWServiceService();
		Flight proxy=jserv.getJetAWServicePort();
		System.out.println(proxy.seatAvailable(src, dest));
		spiceServ=new SpiceAWServiceService();
		proxy=spiceServ.getSpiceAWServicePort();
		System.out.println(proxy.seatAvailable(src, dest));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src="Delhi",dest="Bangalore";
		seatAvailable(src, dest);
		//System.out.println(proxy.seatAvailable("Delhi", "Bangalore"));
	}

}
