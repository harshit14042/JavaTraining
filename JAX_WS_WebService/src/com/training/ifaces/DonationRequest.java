package com.training.ifaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.training.domain.BloodDonor;

@WebService
public interface DonationRequest {
	
	@WebMethod
	public BloodDonor getRequest(@WebParam(name="bldGroup")String bldGroup);
}
