package com.training.domains;

import com.training.ifaces.IAutomobile;

public class BajajBike implements IAutomobile {

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return "Pulsar";
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "Invisible";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return -125000;
	}

}
