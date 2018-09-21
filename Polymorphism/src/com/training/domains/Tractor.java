package com.training.domains;

import com.training.ifaces.IAutomobile;

public class Tractor implements IAutomobile {

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return "John Deer";
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "Invisible";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return -1300000;
	}

}
