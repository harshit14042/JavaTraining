package com.training.domains;

import java.util.ArrayList;
import java.util.List;

public class Service {
	
	private University u;
	
	public void getDetails(long dept){
		u.getDeptDetails(dept);
	}
	
	public static int[] generateMarks(int n){
		int[] m=new int[n];
		for(int i=0;i<n;i++){
			m[i]=(int) Math.ceil(Math.random()*100);
		}
		return m;
	}
	
	public void Initializer(){
		
		Student s1=new Student("Student1",20,generateMarks(3));
		
		Student s2=new Student("Student2",21,generateMarks(3));
		
		Student s3=new Student("Student3",22,generateMarks(3));
		
		Student s4=new Student("Student4",23,generateMarks(3));
		
		Student s5=new Student("Student5",24,generateMarks(3));
		
		Student s6=new Student("Student6",25,generateMarks(3));
		
		List<Student> l1=new ArrayList<Student>();
		l1.add(s1);
		l1.add(s2);
		
		List<Student> l2=new ArrayList<Student>();
		l2.add(s3);
		l2.add(s4);
		
		List<Student> l3=new ArrayList<Student>();
		l3.add(s5);
		l3.add(s6);
		
		Department d1=new Department("CSE",101,l1);
		Department d2=new Department("ECE",102,l2);
		Department d3=new Department("EEE",103,l3);
		
		List<Department> depts=new ArrayList<Department>();
		
		depts.add(d1);
		depts.add(d2);
		depts.add(d3);
		
		u=new University("IIITD","Delhi",depts);
	}
}
