package com.training.beans;

public class Product {

	private long productId;
	private String productName;
	private int quantity;
	private double ratePerUnit;
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", ratePerUnit=" + ratePerUnit + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long productId, String productName, int quantity, double ratePerUnit) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.ratePerUnit = ratePerUnit;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	
	
}
