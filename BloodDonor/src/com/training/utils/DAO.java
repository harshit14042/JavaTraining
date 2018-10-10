package com.training.utils;

import java.sql.SQLException;
import java.util.List;

import com.training.entity.Donor;

public interface DAO {
	public int add(Donor donor) throws SQLException;

	public List<Donor> getAllDonors() throws SQLException;
	
	public List<Donor> searchDonorByLocationAndGroup(String location,String group) throws SQLException;
	
	public List<String> searchDonorByLocation(String location) throws SQLException;
	
	public int updateDonor(String propertyName,String newVal,long id) throws SQLException;
	
	public List<String> getAllLocations() throws SQLException;
	
}
