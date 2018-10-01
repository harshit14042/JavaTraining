package com.training.utils;

import java.sql.SQLException;

import com.training.entity.Contact;

public interface ContactDAO extends DAO<Contact> {
	public void updateRelation(Contact contact,String relation) throws SQLException;
}
