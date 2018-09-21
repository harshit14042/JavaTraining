package com.training.domains;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String departmentName;
	private long deptId;
	private List<Student> students;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s="";
		s+=("Department Name: "+departmentName)+"\n";
		s+=("Department Id: "+deptId)+"\n";
		
		s+=getAverage();
		
		return s;
	}

	public double getAverage(){
		double avg=0;
		for(int i=0;i<this.students.size();i++){
			avg+=(this.students.get(i).getStuAvg());
		}
		return avg/this.students.size();
	}
	
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Department(String departmentName, long deptId, List<Student> students) {
		super();
		this.departmentName = departmentName;
		this.deptId = deptId;
		this.students = students;
	}
	public Department() {
		super();
		students=new ArrayList<Student>();
		// TODO Auto-generated constructor stub
	}
	
	
}
