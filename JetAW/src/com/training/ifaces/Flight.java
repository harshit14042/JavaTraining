package com.training.ifaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Flight {
	
	@WebMethod
	public String seatAvailable(@WebParam(name="src")String src,@WebParam(name="dest")String dest);
}
