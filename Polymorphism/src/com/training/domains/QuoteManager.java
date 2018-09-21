package com.training.domains;

import com.training.ifaces.IAutomobile;

public class QuoteManager {
	
	public void printQuote(IAutomobile polyAuto){
		if(polyAuto!=null){
			System.out.println(polyAuto.getModel());
			System.out.println(polyAuto.getColor());
			System.out.println(polyAuto.getPrice());
		}
		else{
			System.out.println("Invalid Choice");
		}
	}
	/**
	 * 
	 * @param key 1-3 returns the subtype of Automobile class implementing IAutomobile Interface
	 * @return
	 */
	public IAutomobile getModel(int key){
		switch(key){
		case 1:
			return new MarutiCar();
		case 2:
			return new BajajBike();
		default:
			return null;
		}
	}
}
