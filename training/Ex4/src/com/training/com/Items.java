package com.training.com;

import java.io.Serializable;

public class Items implements Serializable {
	long itemId;
	String Type;
	double price;
	int days_rented;
	
	public int getDays_rented() {
		return days_rented;
	}
	public void setDays_rented(int days_rented) {
		this.days_rented = days_rented;
	}
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Items(long itemId, String type, double price) {
		super();
		this.itemId = itemId;
		Type = type;
		this.price = price;
	}
	@Override
	public String toString() {
		return itemId + "," + Type + "," + price+"\n";
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
