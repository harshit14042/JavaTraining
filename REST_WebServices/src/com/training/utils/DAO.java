package com.training.utils;

import java.sql.SQLException;
import java.util.List;

import com.training.beans.*;

public interface DAO {
	public int add(Customer customer) throws SQLException;

	public List<Customer> getAllCustomers() throws SQLException;
}
