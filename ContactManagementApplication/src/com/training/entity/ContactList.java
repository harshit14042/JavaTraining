package com.training.entity;

import java.util.*;

public class ContactList {
	
	public static final String relativeString="Relative";
	public static final String friendString="Friend";
	public static final String officeString="Office";
	private TreeSet<Contact> allContacts;
	
	public static long contactId=0;
	public static long getContactId() {
		return contactId;
	}
	public static void setContactId(long contactId) {
		ContactList.contactId = contactId;
	}
	public Set<Contact> getAllContacts() {
		return allContacts;
	}
	public void setAllContacts(TreeSet<Contact> allContacts) {
		this.allContacts = allContacts;
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
	}
	
	public TreeSet<Contact> getFriendList(){
		TreeSet<Contact> friends=new TreeSet<>();
		
		for(Contact contact:this.allContacts){
			if(contact.getRelation().equals(friendString)){
				friends.add(contact);
			}
		}
		return friends;
	}
	
	public TreeSet<Contact> getRelativeList(){
		TreeSet<Contact> relatives=new TreeSet<>();
		
		for(Contact contact:this.allContacts){
			if(contact.getRelation().equals(relativeString)){
				relatives.add(contact);
			}
		}
		return relatives;
	}
	
	public TreeSet<Contact> getOfficeList(){
		TreeSet<Contact> office=new TreeSet<>();
		
		for(Contact contact:this.allContacts){
			if(contact.getRelation().equals(officeString)){
				office.add(contact);
			}
		}
		return office;
	}
	public ContactList() {
		super();
	}
	
	public boolean deleteContact(Contact contact){
		return this.allContacts.remove(contact);
	}
	
	public boolean addContact(Contact contact){
		return this.getAllContacts().add(contact);
	}
	
	
	
	public boolean addContact(String firstName,String lastName,String email,String relation,TreeSet<Long> numbers){
		boolean status=false;
		Person person=new Person(firstName,lastName,email);
		Contact contact=new Contact(++contactId,person,relation,numbers);
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
			contact.addNumber(Long.parseLong(newVal));
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
	
	public Set<Contact> getContactByName(String nameToSearch){
		Set<Contact> contactList=new HashSet<>();
		for(Contact c:allContacts){
			if(c.getPerson().getFirstName().equals(nameToSearch) || c.getPerson().getLastName().equals(nameToSearch) || nameToSearch.equals(c.getPerson())){
				contactList.add(c);
			}
		}
		return contactList;
	}
	
}
