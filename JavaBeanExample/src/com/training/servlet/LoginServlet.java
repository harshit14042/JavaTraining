package com.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		System.out.println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		
		boolean isValidUser=false;
		
		if(userName.equals("India") && passWord.equals("India")){
			isValidUser=true;
		}
		HttpSession session=request.getSession();
		session.setAttribute("isLoggedIn", isValidUser);
		RequestDispatcher dispatcher=null;
		if(!isValidUser){
			dispatcher=request.getRequestDispatcher("index.jsp");
		}
		else{
			dispatcher=request.getRequestDispatcher("addCustomer.jsp");
		}
		dispatcher.forward(request, response);
		//RequestDispatcher dispatcher;
		/*if(isValidUser){
			dispatcher=request.getRequestDispatcher("Success.jsp");
		}
		else{
			dispatcher=request.getRequestDispatcher("Failure.jsp");
		}
		
		dispatcher.forward(request, response);*/
		//doGet(request, response);
	}

}
