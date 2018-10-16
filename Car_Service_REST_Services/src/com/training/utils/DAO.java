package com.training.utils;

import java.sql.SQLException;

import com.training.entity.Customer;

public interface DAO<T> {

	public T findById(String Id) throws SQLException;
	
	public int addById(T t) throws SQLException;
}
