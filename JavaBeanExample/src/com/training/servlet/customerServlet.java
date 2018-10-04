package com.training.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.beans.Customer;
import com.training.utils.CustomerDAOImpl;
import com.training.utils.DAO;

/**
 * Servlet implementation class customerServlet
 */
public class customerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer cust=(Customer)session.getAttribute("customerBean");
//		response.getWriter().println(cust.toString());
		
		ClassLoader clsLdr=Thread.currentThread().getContextClassLoader();
		InputStream inStream=clsLdr.getResourceAsStream("JDBC.properties");
		
		DAO dao=new CustomerDAOImpl(inStream);
		System.out.println(cust.toString());
		int rows;
		try {
			rows = dao.add(cust);
			if(rows>0)
				request.setAttribute("status","Record Added Successfully");
			else
				request.setAttribute("status","Record Not Added");
			request.setAttribute("customers", dao.getAllCustomers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("showCustomers.jsp");
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
