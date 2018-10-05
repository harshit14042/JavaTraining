package com.training.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.training.utils.CustomerDAOImpl;
import com.training.utils.DAO;

/**
 * Servlet implementation class customerServlet
 */
public class customerServlet extends HttpServlet {
	
	Connection con;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		try {
			Context ctx=new InitialContext();
			
			DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
			
			con=dataSource.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
//		response.getWriter().println(cust.toString());
		
		/*ClassLoader clsLdr=Thread.currentThread().getContextClassLoader();
		InputStream inStream=clsLdr.getResourceAsStream("JDBC.properties");*/
		
		DAO dao=new CustomerDAOImpl(con);
		try {
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
//		HttpSession session=request.getSession();
//		Customer cust=(Customer)session.getAttribute("customerBean");
////		response.getWriter().println(cust.toString());
//		
//		ClassLoader clsLdr=Thread.currentThread().getContextClassLoader();
//		InputStream inStream=clsLdr.getResourceAsStream("JDBC.properties");
//		
//		DAO dao=new CustomerDAOImpl(inStream);
//		System.out.println(cust.toString());
//		int rows;
//		try {
//			rows = dao.add(cust);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
//		dispatcher.forward(request, response);
//	}
	}
	
}
