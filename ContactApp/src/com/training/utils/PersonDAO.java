package com.training.utils;
import java.sql.SQLException;

import com.training.entity.Person;

public interface PersonDAO extends DAO<Person> {
	public void updateFirstName(Person person,String firstName) throws SQLException;
	public void updateLastName(Person person,String lastName) throws SQLException;
	public void updateEmail(Person person,String email) throws SQLException;
	public void updateContactNumber(Person person,long prevNumber,long newNumber) throws SQLException;

	public void removeContactNumber(Person person, long number) throws SQLException;
	public void addContactNumber(Person person,Long number) throws SQLException;
}
