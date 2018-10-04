package com.training.utils;

import java.sql.SQLException;

import com.training.beans.*;

public interface DAO {
	public int add(Customer customer) throws SQLException;
}
