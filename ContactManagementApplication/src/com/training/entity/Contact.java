package com.training.entity;

import java.util.*;

public class Contact implements Comparable<Contact>{
	private long contactId;
	private Person person;
	private String relation;
	private TreeSet<Long> numbers;
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public Set<Long> getNumbers() {
		return numbers;
	}
	public void setNumbers(TreeSet<Long> numbers) {
		this.numbers = numbers;
	}
	@Override
	public String toString() {
		String s="";
		s="First Name: "+this.getPerson().getFirstName()+"\nLast Name: "+this.getPerson().getLastName()+"\nEmail: "+this.getPerson().getEmail()+"\nRelation: "+this.getRelation()+"\nContact Number:";
		s+="\n";
		for(long num:this.getNumbers()){
			s+=(num+"\n");
		}
		return s;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contactId ^ (contactId >>> 32));
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
		Contact other = (Contact) obj;
		if (contactId != other.contactId)
			return false;
		return true;
	}	
	
	public Contact(long contactId,Person person, String relation, TreeSet<Long> numbers) {
		super();
		this.contactId = contactId;
		this.person = person;
		this.relation = relation;
		this.numbers = numbers;
	}
	
	public Contact(Person person, String relation, TreeSet<Long> numbers) {
		super();
		long newCustomerId=ContactList.getContactId();
		newCustomerId++;
		ContactList.setContactId(newCustomerId);
		this.contactId = newCustomerId;
		this.person = person;
		this.relation = relation;
		this.numbers = numbers;
	}
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Contact arg0) {
		// TODO Auto-generated method stub
		return this.getPerson().getFirstName().toUpperCase().compareTo(arg0.getPerson().getFirstName().toUpperCase());
		
	}
	public void addNumber(long num) {
		// TODO Auto-generated method stub
		this.getNumbers().add(num);
		
	}
	public void editRelation(String newVal) {
		// TODO Auto-generated method stub
		this.setRelation(newVal);
	}
	
	
	
	
}
