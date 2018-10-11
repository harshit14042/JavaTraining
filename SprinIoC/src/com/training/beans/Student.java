package com.training.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("student")
public class Student {

	@Value("Toni")
	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + "]";
	}

	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
