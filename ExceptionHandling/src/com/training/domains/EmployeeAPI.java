package com.training.domains;
import java.util.*;

public interface EmployeeAPI {
	public boolean add(Employee... emp);
	
	public List<Employee> findAll();
	
	public List<Employee> sortById(String sortOrder);
	
	public List<Employee> sortByName();
	
	public List<Employee> sortByAge();
}
