package com.training.beans;

public class Teacher {

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
	private Student student;
	
}
