package com.training.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entity.Contact;
import com.training.entity.ContactList;
import com.training.utils.ContactDAO;
import com.training.utils.ContactDAOImplementation;
import com.training.utils.DbConnections;

/**
 * Servlet implementation class viewCategoryWise
 */
public class viewCategoryWise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewCategoryWise() {
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
		InputStream inStream=clsLdr.getResourceAsStream("JDBC.properties");
		
		Connection conn=DbConnections.getConnection(inStream);
		
		ContactDAO dao=new ContactDAOImplementation(conn);
		RequestDispatcher dispatcher=request.getRequestDispatcher("categoryWiseView.jsp");
		try {
			TreeSet<Contact> contacts=dao.findAll();
			ContactList contactList=new ContactList(contacts);
			request.setAttribute("friendList", contactList.getFriends());
			request.setAttribute("relativeList", contactList.getRelatives());
			request.setAttribute("officeList", contactList.getOffice());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
		
	}

}
