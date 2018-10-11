package com.training.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("teacher")
public class Teacher {

	@Value("Valverde")
	private String teacherName;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String teacherName, Student student) {
		super();
		this.teacherName = teacherName;
		this.student = student;
	}
	@Override
	public String toString() {
		return "Teacher [teacherName=" + teacherName + ", student=" + student + "]";
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Autowired
	private Student student;
	
}
