package com.training.domains;

public class Doctor implements Comparable<Doctor> {
	private String name;
	private String Specialization;
	private String city;
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", Specialization=" + Specialization + ", city=" + city + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Doctor(String name, String specialization, String city) {
		super();
		this.name = name;
		Specialization = specialization;
		this.city = city;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Doctor o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
}
