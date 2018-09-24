package com.training.entity;

public class Student {
	private long studentId;
	private String studentName;
	private long courseId;
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", courseId=" + courseId + "]";
	}
	public Student(long studentId, String studentName, long courseId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
