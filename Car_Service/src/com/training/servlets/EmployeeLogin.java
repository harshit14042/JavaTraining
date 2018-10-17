package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.utils.DAO;
import com.training.utils.DAOImpl;

/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userId=request.getParameter("userId");
		String passWord=request.getParameter("passWord");
		RequestDispatcher dispatcher=null;
		DAO dao=null;
		try {
			dao = new DAOImpl();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(request.getParameter("type").equals("login")) {
		
			boolean isValid=false;
			
			try {
				isValid=dao.validate(userId, passWord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(isValid) {
				dispatcher=request.getRequestDispatcher("main.html");
			}
			else {
				dispatcher=request.getRequestDispatcher("index.html");
			}
		}
		else {
			try {
				System.out.println(userId+" "+passWord);
				dao.register(userId, passWord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher=request.getRequestDispatcher("index.html");
		}
		dispatcher.forward(request, response);
		
	}

}
