package com.training.services;

import javax.jws.WebService;

import com.training.ifaces.CurrencyConverter;

@WebService(endpointInterface="com.training.ifaces.CurrencyConverter")
public class CurrencyConverterImpl implements CurrencyConverter {

	@Override
	public double dolorToRupees(double dlrAmt) {
		// TODO Auto-generated method stub
		return dlrAmt*74;
	}

}
