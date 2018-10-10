package com.training.services;

import java.util.HashMap;

import javax.jws.WebService;

import com.training.domain.BloodDonor;
import com.training.ifaces.DonationRequest;

@WebService(endpointInterface="com.training.ifaces.DonationRequest")
public class DonationRequestService implements DonationRequest {

	private HashMap<String,BloodDonor> donorList;
	
	public DonationRequestService() {
		super();
		// TODO Auto-generated constructor stub
		donorList=new HashMap<>();
		donorList.put("apos", new BloodDonor(101, "Ramesh","apos", "Chennai"));
		donorList.put("opos", new BloodDonor(102, "Rajesh","opos", "Pune"));
		donorList.put("bpos", new BloodDonor(103, "Rakesh","bpos", "Delhi"));
	}

	@Override
	public BloodDonor getRequest(String bldGroup) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return donorList.get(bldGroup);
	}

}
