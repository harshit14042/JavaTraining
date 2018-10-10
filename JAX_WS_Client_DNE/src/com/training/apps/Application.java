package com.training.apps;

import com.training.clients.Calculator;
import com.training.clients.CalculatorSoap;

public class Application {
	public static void main(String[] args){
	Calculator conv=new Calculator();
	
	CalculatorSoap proxy=conv.getCalculatorSoap();
	
	System.out.println(proxy.add(1, 2));
	System.out.println(proxy.subtract(5, 2));
	}
}
