package com.training.domains;

public class RangeCheckException extends Exception {

	private String obj;
	
	public RangeCheckException(String obj) {
		super();
		this.obj = obj;
	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		//return super.getMessage();
		return "Runtime Exception Occured with Message: "+obj;
	}
	
}
