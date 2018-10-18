package com.training.utils;

import java.sql.SQLException;

import com.training.entity.Customer;

public interface CustomerDAO extends GDAO<Customer> {

	public int updatebyId(String Id, String property, String newVal) throws SQLException;
	
	public long getNewId() throws SQLException;
	
}
