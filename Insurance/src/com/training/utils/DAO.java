package com.training.utils;

import java.sql.SQLException;

import com.training.entity.Insurance;

public interface DAO<T> {

	
	public String getbyId(String carNo) throws SQLException;
	
}
