package com.training.com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable{
	private long Id;
	private String Name;
	private long contact;
	
	private List<Order> orders=new ArrayList<>();

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer Deatils:\nId=" + Id + ", Name=" + Name + ", contact=" + contact + "\nOrders=" + orders;
	}

	public Customer(long id, String name, long contact, List<Order> orders) {
		super();
		Id = id;
		Name = name;
		this.contact = contact;
		this.orders = orders;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}