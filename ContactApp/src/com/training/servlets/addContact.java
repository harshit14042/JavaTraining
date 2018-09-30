package com.training.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entity.Contact;
import com.training.entity.ContactList;
import com.training.entity.Person;
import com.training.utils.ContactDAO;
import com.training.utils.ContactDAOImplementation;
import com.training.utils.DbConnections;

/**
 * Servlet implementation class addContact
 */
public class addContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addContact() {
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
		ClassLoader clsLdr=Thread.currentThread().getContextClassLoader();
		InputStream instream=clsLdr.getResourceAsStream("JDBC.properties");
		
		Connection conn=DbConnections.getConnection(instream);
		
		ContactDAO dao=new ContactDAOImplementation(conn);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Index");
		
		long id=ContactList.getContactId();
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		Set<Long> numbers=new HashSet<>();
		numbers.add(Long.parseLong(request.getParameter("number")));
		
		String relation=request.getParameter("relation");
		
		Person person=new Person(++id, firstName, lastName, numbers, email);
		
		Contact contact=new Contact(id, person, relation);
		
		ContactList.setContactId(id);
		
		dao.add(contact);
		
		dispatcher.forward(request, response);
	}

}
