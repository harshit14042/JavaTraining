package com.training.utils;

import com.training.entity.ContactNumber;
import com.training.entity.Person;

public interface PersonDAO extends DAO<Person> {
	public void updateFirstName(Person person,String firstName);
	public void updateLirstName(Person person,String lastName);
	public void updateEmail(Person person,String email);
	public void updateContactNumber(Person person,ContactNumber cNumber,long number);
	public void updateContactNumber(Person person,ContactNumber cNumber,String type);

	public void removeContactNumber(Person person,ContactNumber contactNumber);
	public void addContactNumber(Person person,ContactNumber contactNumber);
}
