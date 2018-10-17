package com.training.entity;
public class Customer {
	private long customer_id;
	private String cname;
	private String addr;
	private String email;
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customer_id ^ (customer_id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customer_id != other.customer_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", cname=" + cname + ", addr=" + addr + ", email=" + email
				+ "]";
	}
	public Customer(long customer_id, String cname, String addr, String email) {
		super();
		this.customer_id = customer_id;
		this.cname = cname;
		this.addr = addr;
		this.email = email;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
