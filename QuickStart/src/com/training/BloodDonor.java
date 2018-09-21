package com.training;

public class BloodDonor {
	//Instance Variables
	//Instance variable has default value 0 for int and null for String false for boolean 0.0 for double
	private String name;
	private String gender;
	private int age;
	private String bloodGroup;
	public String toString(){
		return name+" "+age+" "+gender;
	}
	public String collectCertificate(){
		return "Collected";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public BloodDonor(String name, String gender, int age, String bloodGroup) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.bloodGroup = bloodGroup;
	}
	public BloodDonor() {
		super();
		// TODO Auto-generated constructor stub
	}
}
