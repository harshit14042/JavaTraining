package com.training;

public class Doctor {
	private String name;
	private String doctorid;
	private String location;
	private String department;
	private String speciality;
	private int age;
	private String qualification;
	private int experience;
	private String phoneNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String askPatientDetail(){
		return "Patient Details";
	}
	public String giveTreatment(){
		return "Treatment Given";
	}
	public String recordPatientHealth(){
		return "Patient Health Record";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return qualification;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Doctor(String name, String speciality, int age, String qualification, int experience) {
		super();
		this.name = name;
		this.speciality = speciality;
		this.age = age;
		this.qualification = qualification;
		this.experience = experience;
	}
}
