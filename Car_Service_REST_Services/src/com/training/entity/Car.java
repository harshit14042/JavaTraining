package com.training.entity;

public class Car {

	private String car_no;
	private long customer_id;
	private String company;
	private String car_model;
	private int car_age;
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public int getCar_age() {
		return car_age;
	}
	public void setCar_age(int car_age) {
		this.car_age = car_age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + car_age;
		result = prime * result + ((car_model == null) ? 0 : car_model.hashCode());
		result = prime * result + ((car_no == null) ? 0 : car_no.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
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
		Car other = (Car) obj;
		if (car_age != other.car_age)
			return false;
		if (car_model == null) {
			if (other.car_model != null)
				return false;
		} else if (!car_model.equals(other.car_model))
			return false;
		if (car_no == null) {
			if (other.car_no != null)
				return false;
		} else if (!car_no.equals(other.car_no))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (customer_id != other.customer_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [car_no=" + car_no + ", customer_id=" + customer_id + ", company=" + company + ", car_model="
				+ car_model + ", car_age=" + car_age + "]";
	}
	public Car(String car_no, long customer_id, String company, String car_model, int car_age) {
		super();
		this.car_no = car_no;
		this.customer_id = customer_id;
		this.company = company;
		this.car_model = car_model;
		this.car_age = car_age;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
