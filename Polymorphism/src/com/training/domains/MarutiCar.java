package com.training.domains;

import com.training.ifaces.IAutomobile;

public class MarutiCar implements IAutomobile {

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return "Swift Dezire";
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "Transparent";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return -700000;
	}

}
