package com.training.entity;

import java.util.*;

public class ContactList {
	
	private static final String relativeString="Relative";
	private static final String friendString="Friend";
	private static final String officeString="Office";
	
	private static long contactId=0;
	private TreeSet<Contact> allContacts;
	private TreeSet<Contact> friends;
	private TreeSet<Contact> relatives;
	private TreeSet<Contact> office;
	private Map<String,TreeSet<Contact>> typeToList=new HashMap<>();
	public Set<Contact> getAllContacts() {
		return allContacts;
	}
	public void setAllContacts(TreeSet<Contact> allContacts) {
		this.allContacts = allContacts;
	}
	@Override
	public String toString() {
		return "ContactList [allContacts=" + allContacts + ", friends=" + friends + ", relatives=" + relatives
				+ ", office=" + office + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allContacts == null) ? 0 : allContacts.hashCode());
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
		ContactList other = (ContactList) obj;
		if (allContacts == null) {
			if (other.allContacts != null)
				return false;
		} else if (!allContacts.equals(other.allContacts))
			return false;
		return true;
	}
	public ContactList(TreeSet<Contact> allContacts) {
		super();
		this.allContacts = allContacts;
		arrangeContacts();
	}
	
	private void arrangeContacts(){
		this.allContacts=new TreeSet<>();
		this.friends=new TreeSet<>();
		this.relatives=new TreeSet<>();
		this.office=new TreeSet<>();
		for(Contact contact:this.allContacts){
			if(contact.getRelation().equals(relativeString)){
				this.relatives.add(contact);
			}
			else if(contact.getRelation().equals(friendString)){
				this.friends.add(contact);
			}
			else{
				this.office.add(contact);
			}
		}
		this.typeToList.put(friendString,this.friends);
		this.typeToList.put(relativeString,this.relatives);
		this.typeToList.put(officeString,this.office);
	}
	
	public ContactList() {
		super();
		arrangeContacts();
	}
	
	public boolean deleteContact(Contact contact){
		this.typeToList.get(contact.getRelation()).remove(contact);
		return this.allContacts.remove(contact);
	}
	
	public boolean addContact(Contact contact){
		this.typeToList.get(contact.getRelation()).add(contact);
		return this.getAllContacts().add(contact);
	}
	
	
	
	public boolean addContact(String firstName,String lastName,String email,String relation,Set<Long> numbers){
		boolean status=false;
		Person person=new Person(++contactId,firstName,lastName,numbers,email);
		Contact contact=new Contact(contactId,person,relation);
		addContact(contact);
		status = true;
		return status;
	}
	
	public void editContact(Contact contact,String property,String newVal){
		if(property.equals("firstName")){
			contact.getPerson().editFirstName(newVal);
		}
		else if(property.equals("lastName")){
			contact.getPerson().editLastName(newVal);
		}
		else if(property.equals("addNumber")){
			contact.getPerson().addNumber(Long.parseLong(newVal));
		}
		else if(property.equals("email")){
			contact.getPerson().editEmail(newVal);
		}
		else if(property.equals("relation")){
			contact.editRelation(newVal);
		}
	}
	
	public TreeSet<Contact> getContactDetails(String Name){
		TreeSet<Contact> results=new TreeSet<>();
		for(Contact contact:allContacts){
			if(contact.getPerson().getFirstName().equals(Name) || contact.getPerson().getLastName().equals(Name)){
				results.add(contact);
			}
		}
		return results;
	}
	
}
