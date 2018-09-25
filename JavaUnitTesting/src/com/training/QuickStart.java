package com.training;

public class QuickStart {

	public String getMessage(){
		return "Hello".toUpperCase();
	}
	
	public double calculateDiscount(double amount){
		double discount=0.0;
		if(amount<0){
			throw new IllegalArgumentException("Amount should be positive");
		}
		if(amount<=5000){
			discount=0.1;
		}
		else{
			discount=0.15;
		}
		return discount;
	}
	
}
