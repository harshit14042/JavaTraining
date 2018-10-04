package com.training.utils;

import java.sql.SQLException;
import java.util.*;

import com.training.entity.Contact;


public interface DAO<T> {
	public int add(T obj) throws SQLException;
	public TreeSet<T> findAll() throws SQLException;
	
	//TO DO
	public int removeContact(long key) throws SQLException;
	
	public TreeSet<Long> getNumbersById(long Id) throws SQLException;
	//We need to do
	public T findByPrimaryKey(long key) throws SQLException;
	
	public int updateContactList(Contact contact,String propertyName,String updatedValue) throws SQLException;

	public void removeContactNumber(long number) throws SQLException;
	void addContactNumber(long id, Long number) throws SQLException;
	//void updateContactNumber(Person person, long prevNumber, long newNumber) throws SQLException;
	void updateContactNumber(long prevNumber, long newNumber) throws SQLException;
	public TreeSet<Long> getAllNumbers() throws SQLException;
	
	public TreeSet<String> getAllNames() throws SQLException;
	
	public TreeSet<Contact> getContactsByRelation(String relation) throws SQLException;
}