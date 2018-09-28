package com.training;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entity.DAO;
import com.training.entity.Movie;
import com.training.entity.MovieDAOImpl;
import com.training.utils.DbConnections;

/**
 * Servlet implementation class Movie
 */
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ClassLoader clsLdr=Thread.currentThread().getContextClassLoader();
		InputStream stream=clsLdr.getResourceAsStream("JDBC.properties");
		
		//System.out.println(stream);
		
		Connection conn=DbConnections.getConnection(stream);
		
		//System.out.println(conn);
		DAO<Movie> dao=new MovieDAOImpl(conn);
		RequestDispatcher dispatcher=request.getRequestDispatcher("showMovies.jsp");
		try {
			List<Movie> movieList=dao.findAll();
			request.setAttribute("movieList", movieList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
