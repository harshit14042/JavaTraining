package com.training.entity;

import java.sql.SQLException;

public interface MovieDAO extends DAO<Movie> {

	public int updateRating(long movieId,double currentRating) throws SQLException;
	
}
