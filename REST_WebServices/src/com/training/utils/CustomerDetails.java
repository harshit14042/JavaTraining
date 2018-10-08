package com.training.utils;

import java.util.HashMap;

import com.training.beans.Customer;

public class CustomerDetails {

	private static HashMap<Long,Customer>custList;
	static{
		
		custList=new HashMap<>();
		custList.put(101L, new Customer(103,"mia",9986756));
		custList.put(102L, new Customer(102,"lia",9986756));
	}
	public static Customer getCustomer(long key){
		return custList.get(key);
	}
	
	
	public static HashMap<Long,Customer> getAllCustomer(){
		return custList;
	}
	
	
	public static String addCustomer(Customer cust){
		
		String message="Added";
		Customer result=(Customer)custList.put(cust.getCustomerId(), cust);
		
		if(result!=null){
			message ="replaced";
		}
		return message;
		}
}
