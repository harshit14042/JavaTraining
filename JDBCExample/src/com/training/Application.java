package com.training;

import java.sql.SQLException;

import com.training.entity.Movie;
import com.training.entity.MovieDAO;
import com.training.entity.DAO;
import com.training.entity.MovieDAOImpl;
import com.training.utils.DbConnections;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DbConnections.getConnection());
		
		/*Movie movie=new Movie(101, "The Dark Knight", "Christopher Nolan", "Crime", 4.9);
		Movie movie1=new Movie(102, "Batman Begins", "Christopher Nolan", "Crime", 4.0);
		Movie movie2=new Movie(103, "Dark Knight Rises", "Christopher Nolan", "Crime", 4.5);*/
		System.out.println("Hello");
		MovieDAO doa=new MovieDAOImpl();
		
		//int rowAdded=doa.addMovie(movie2);
		
		
		
		//System.out.println(rowAdded+" Rows Added");
		//System.out.println(doa.findAll());
		int key=5;
		try{
		switch(key){
		case 1:
			Movie movie=new Movie(101, "The Dark Knight", "Christopher Nolan", "Crime", 4.9);
			int rowAdded=doa.add(movie);
			System.out.println(rowAdded+" Rows Added");
			break;
		case 2:
			System.out.println(doa.findAll());
			break;
		case 3:
			System.out.println(doa.findByPrimaryKey(103));
			break;
		case 4:
			System.out.println(doa.remove(101));
			break;
		case 5:
			System.out.println(doa.updateRating(102, 4.9));
		default:
			break;
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		((MovieDAOImpl)doa).closeConnection(); 
		
		/*try {
			DbConnections.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}