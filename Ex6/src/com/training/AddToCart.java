package com.training;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCart
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddToCart() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		Map<String,String[]> items=(Map<String, String[]>) session.getAttribute("cart");
		RequestDispatcher dispatcher=null;
		if((int)session.getAttribute("jspPage")==1){
			String[] it=new String[1];
			String s=(String)request.getParameter("bookSelection");
			System.out.println(s);
			it[0]=s;
			items=new HashMap<>();
			items.put("Books", it);
			dispatcher=request.getRequestDispatcher("gadgetSelection.jsp");
		}
		else if((int)session.getAttribute("jspPage")==2){
			String[] it=new String[1];
			String s=(String)request.getParameter("gadgetSelection");
			it[0]=s;
			items.put("Gadgets", it);
			dispatcher=request.getRequestDispatcher("couponSelection.jsp");
		}
		else{
			items.put("Coupons", request.getParameterValues("couponSelection"));
			dispatcher=request.getRequestDispatcher("allSelection.jsp");
			System.out.println(items);
		}
		session.setAttribute("cart", items);
		int jspPage=(int)session.getAttribute("jspPage");
		jspPage++;
		session.setAttribute("jspPage",jspPage);
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
