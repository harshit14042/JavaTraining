package com.training.entity;

import java.util.*;

public class Person {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private Set<Long> numbers;
	
	
	
	public void editEmail(String email){
		this.setEmail(email);
	}
	
	public void editFirstName(String firstName){
		this.setFirstName(firstName);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void editLastName(String lastName){
		this.setLastName(lastName);
	}
	
	public void removeNumber(Long num){
		this.numbers.remove(num);
	}
	
	public void addNumber(Long num){
		this.numbers.add(num);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Long> getNumbers() {
		return numbers;
	}
	public void setNumbers(Set<Long> numbers) {
		this.numbers=numbers;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", numbers=" + numbers + ", email=" + email
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	public Person(long id,String firstName, String lastName, Set<Long> numbers, String email) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.numbers = numbers;
		this.email = email;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
