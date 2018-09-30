package com.training.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.utils.ContactDAO;
import com.training.utils.ContactDAOImplementation;
import com.training.utils.DbConnections;

/**
 * Servlet implementation class removeContact
 */
public class removeContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		long contactId=(long) request.getAttribute("contactId");
		ClassLoader clsLdr=Thread.currentThread().getContextClassLoader();
		InputStream stream=clsLdr.getResourceAsStream("JDBC.properties");
		
		Connection conn=DbConnections.getConnection(stream);
		
		ContactDAO dao=new ContactDAOImplementation(conn);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Index");
		try {
			dao.remove(contactId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.removeAttribute("contactId");
		dispatcher.forward(request, response);
	}

}
