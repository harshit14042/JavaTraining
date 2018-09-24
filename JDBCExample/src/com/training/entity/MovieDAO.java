package com.training.entity;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO {
	public int addMovie(Movie movie);
	public List<Movie> findAll() throws SQLException;
	
	//TO DO
	public int remove(long movieId) throws SQLException;
	public int updateRating(long movieId,double currentRating) throws SQLException;
	
	//We need to do
	public Movie findByPrimaryKey(long movieId) throws SQLException;
}
