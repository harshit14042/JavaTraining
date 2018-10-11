package com.training.beans;

import java.util.logging.Logger;

public class Invoice {

	private long invoiceNumber;
	private String customerName;
	private double invoiceAmount;
	
	private static Logger log=Logger.getAnonymousLogger();
	
	
	
	public Invoice(long invoiceNumber, String customerName, double invoiceAmount) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.customerName = customerName;
		this.invoiceAmount = invoiceAmount;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		log.info("Set Invoice Number Called");
		this.invoiceNumber = invoiceNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		log.info("Set Customer Name Called");
		this.customerName = customerName;
	}
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(double invoiceAmount) {
		log.info("Set Invoice Amt Called");
		this.invoiceAmount = invoiceAmount;
	}
	
	
	
}
