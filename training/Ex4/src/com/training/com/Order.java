package com.training.com;

import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable {
	private long orderId;	
	
	private double price;
	
	private HashMap<Items,Integer> items=new HashMap<>();
	
	public void addItem(Items item,int quantity){
		//this.orders.put(item, quantity);
		int qty;
		if(items.containsKey(item)){
			qty=items.get(item);
			qty+=quantity;
		}
		else{
			qty=quantity;
		}
		items.put(item, qty);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public HashMap<Items, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<Items, Integer> items) {
		this.items = items;
	}

	public Order(long orderId, HashMap<Items, Integer> items) {
		super();
		this.orderId = orderId;
		this.items = items;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "orderId=" + orderId + ", items=" + items+"\n";
	}	
	
	
}