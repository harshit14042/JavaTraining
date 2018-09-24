package com.training.domains;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private int age;
	private int[] marks;
	
	public double getStuAvg(){
		double avg=0;
		int total=this.getmarks().length;
		int[] marks=this.getmarks();
		for(int i=0;i<total;i++){
			avg+=marks[i];
		}
		return avg/total;
	}
	
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
	public int[] getmarks() {
		return marks;
	}
	public void setmarks(int[] marks) {
		this.marks = marks;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age, int[] marks) {
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	
	
}
