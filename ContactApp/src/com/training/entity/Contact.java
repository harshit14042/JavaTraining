package com.training.entity;

public class Contact implements Comparable<Contact>{
	private long contactId;
	private Person person;
	private String relation;
	
	public void editRelation(String relation){
		this.setRelation(relation);
	}
	
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPersons(Person person) {
		this.person = person;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", persons=" + person + ", relation=" + relation + "]";
	}
	public Contact(long contactId, Person person, String relation) {
		super();
		this.contactId = contactId;
		this.person = person;
		this.relation = relation;
	}
	public Contact() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contactId ^ (contactId >>> 32));
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}
	@Override
	public int compareTo(Contact contact) {
		// TODO Auto-generated method stub
		int comp=this.getPerson().getFirstName().compareTo(contact.getPerson().getFirstName());
		if(comp==0){
			comp=this.getPerson().getLastName().compareTo(contact.getPerson().getLastName());
		}
		return comp;
	}
	
	
}
