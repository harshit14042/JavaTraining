package com.training.domains;

import java.util.List;

public class CollectionApplication {

	
	public static void printEmployees(List<Employee> l){
		l.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		Employee.ord=-1;
		Employee e=new Employee(50, "AHV",3);
		Employee e1=new Employee(48, "ZHV1",5);
		Employee e2=new Employee(41, "VHV2",1);
		EmployeeServices emp=new EmployeeServices();
		
		emp.add(e,e1,e2);
		
		emp.findAll().forEach(System.out::println);
		
		List<Employee> em=emp.sortByName();
		
		printEmployees(em);
		
		
		em=emp.sortByAge();
		
		printEmployees(em);
		
		
	}

}
