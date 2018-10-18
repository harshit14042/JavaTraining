package com.training.utils;

import java.sql.SQLException;

import com.training.entity.Customer;

public interface GDAO<T> {

	public T findById(String Id) throws SQLException;
	
	public int add(T t) throws SQLException;
}
