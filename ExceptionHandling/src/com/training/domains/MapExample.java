package com.training.domains;
import java.util.*;
public class MapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Employee> empList=new HashMap<>();
		Employee e=new Employee(50, "AHV",3);
		Employee e1=new Employee(48, "ZHV1",5);
		Employee e2=new Employee(41, "VHV2",1);
		int k=1;
		empList.put(k++,e);
		empList.put(k++,e1);
		empList.put(k++,e2);
		
		System.out.println(empList.entrySet());
		
		System.out.println(empList);
	}

}