package com.training.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.utils.DbConnections;

public class MovieDAOImpl implements MovieDAO {

	private Connection conn;
	
	
	
	
	public MovieDAOImpl(Connection conn) {
		super();
		this.conn=conn;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(Movie movie) {
		// TODO Auto-generated method stub
		String sql="insert into moviehv values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		int rowAdded=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, movie.getMovieId());
			pstmt.setString(2, movie.getMovieName());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getGenre());
			pstmt.setDouble(5, movie.getRating());
			rowAdded=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowAdded;
	}
	
	private Movie convertToObject(ResultSet rs) throws SQLException{
		long movieId=rs.getLong("movieId");
		String movieName=rs.getString("movieName");
		String director=rs.getString("director");
		String genre=rs.getString("genre");
		Double rating=rs.getDouble("rating");
		
		Movie movie=new Movie(movieId, movieName, director, genre, rating);
		return movie;
	}

	@Override
	public List<Movie> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from moviehv";
		PreparedStatement pstmt=null;
		ArrayList<Movie> movieList=new ArrayList<Movie>();
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				Movie movie=convertToObject(rs);
				movieList.add(movie);
			}
		return movieList;
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public int remove(long movieId) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from moviehv where movieId=?";
		PreparedStatement pstmt=null;
		int rowsDeleted=0;
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, movieId);
			rowsDeleted=pstmt.executeUpdate();
		return rowsDeleted;
	}

	@Override
	public int updateRating(long movieId, double currentRating) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update moviehv set rating=? where movieId=?";
		PreparedStatement ps=null;
		int rowUpd=0;
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, currentRating);
			ps.setLong(2, movieId);
			rowUpd=ps.executeUpdate();
		return rowUpd;
	}

	@Override
	public Movie findByPrimaryKey(long movieId) throws SQLException {
		// TODO Auto-generated method stub
		String sql="Select * from moviehv where movieId=?";
		PreparedStatement pstmt=null;
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, movieId);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
				
				
				Movie movie=convertToObject(rs);
				return movie;
			}
		return null;
	}

}
