package com.training.beans;

public class Customer {

	private String customerName;
	private long mobileNumber;
	public String getCustomerName() {
		return customerName;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerName, long mobileNumber) {
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
