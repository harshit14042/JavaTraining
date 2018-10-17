package com.training.utils;

import java.sql.SQLException;

public interface DAO<T> {

	public boolean validate(String userId, String passWord) throws SQLException;
	
	public int register(String userId,String passWord) throws SQLException;
	
}
