package com.training.beans;

import java.util.List;
import java.util.logging.Logger;

public class Invoice {

	private long invoiceNumber;
	private Customer customer;
	private double invoiceAmount;
	private List<Product> productList;
	
	private static Logger log=Logger.getAnonymousLogger();
	
	
	
	public Invoice(long invoiceNumber, Customer customer, double invoiceAmount, List<Product> productList) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.customer = customer;
		this.invoiceAmount = invoiceAmount;
		this.productList = productList;
	}
	public Invoice(long invoiceNumber, Customer customerName, double invoiceAmount) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.customer = customerName;
		this.invoiceAmount = invoiceAmount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public static Logger getLog() {
		return log;
	}
	public static void setLog(Logger log) {
		Invoice.log = log;
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
	public Customer getCustomerName() {
		return customer;
	}
	public void setCustomerName(Customer customer) {
		log.info("Set Customer Called");
		this.customer = customer;
	}
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(double invoiceAmount) {
		log.info("Set Invoice Amt Called");
		this.invoiceAmount = invoiceAmount;
	}
	public double totalAmount() {
		double amt=0;
		for(Product p:productList) {
			amt+=p.getRatePerUnit()*p.getQuantity();
		}
		return amt;
	}
	
	
}
