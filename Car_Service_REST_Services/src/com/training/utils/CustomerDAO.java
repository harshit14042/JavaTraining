package com.training.utils;

import java.sql.SQLException;

import com.training.entity.Customer;

public interface CustomerDAO extends DAO<Customer> {

	public int updatebyId(String Id, String property, String newVal) throws SQLException;
	
	
	
}
