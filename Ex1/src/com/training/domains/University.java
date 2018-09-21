package com.training.domains;

import java.util.*;

public class University {
	private String universityName;
	private String city;
	private List<Department> depts;
	
	public void getDeptDetails(long deptId){
		int i=0;
		for(i=0;i<depts.size();i++){
			if(depts.get(i).getDeptId()==deptId){
				System.out.println(depts.get(i).toString());
				break;
			}
		}
		if(i==depts.size()){
			System.err.println("No Such Department");
		}
	}
	
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Department> getDepts() {
		return depts;
	}
	public void setDepts(List<Department> depts) {
		this.depts = depts;
	}
	public University(String universityName, String city, List<Department> depts) {
		super();
		this.universityName = universityName;
		this.city = city;
		this.depts = depts;
	}
	public University() {
		super();
		depts=new ArrayList<Department>();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
