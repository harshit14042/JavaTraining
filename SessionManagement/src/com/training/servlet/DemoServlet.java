package com.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		System.out.println(session.getCreationTime());
		
		System.out.println(session.getLastAccessedTime());
		//session.invalidate();
		session.setAttribute("city", "Delhi");
		long time=-1*(session.getCreationTime()-session.getLastAccessedTime());
		
		long inactiveTime=session.getMaxInactiveInterval();
		session.removeAttribute("name");
		if(time>inactiveTime){
			session.invalidate();
		}
		session.setAttribute("city", "Bangalore");
		System.out.println(time);
		//response.getWriter().println("<a href='Info.jsp'>Info</a>");
		
		request.getRequestDispatcher("Info.jsp").forward(request, response);;
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
