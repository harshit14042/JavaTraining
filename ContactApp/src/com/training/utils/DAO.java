package com.training.utils;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	public int add(T obj);
	public List<T> findAll() throws SQLException;
	
	//TO DO
	public int remove(long key) throws SQLException;
	
	
	//We need to do
	public T findByPrimaryKey(long key) throws SQLException;
}