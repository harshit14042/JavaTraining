package com.training.domains;

public class Patient implements Comparable<Patient>{
	private String name;
	private int age;
	private String mobileNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Patient(String name, int age, String mobileNumber) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Patient o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + ", mobileNumber=" + mobileNumber + "]";
	}
	
}
