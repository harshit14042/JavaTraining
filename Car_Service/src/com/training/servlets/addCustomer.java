package com.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entity.Car;
import com.training.entity.Customer;
import com.training.utils.CarDAOImpl;
import com.training.utils.CustomerDAO;
import com.training.utils.CustomerDAOImpl;
import com.training.utils.GDAO;

/**
 * Servlet implementation class addCustomer
 */
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCustomer() {
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
		GDAO dao;
		CustomerDAO cDao;
		try {
			dao=new CarDAOImpl();
			cDao=new CustomerDAOImpl();
			String cname=request.getParameter("cname");
			String addr=request.getParameter("addr");
			String email=request.getParameter("email");
			String car_no=request.getParameter("car_no");
			String company=request.getParameter("company");
			String car_model=request.getParameter("car_model");
			int car_age=Math.max(0, Integer.parseInt(request.getParameter("car_age")));
			long customer_id=cDao.getNewId();
			Car car=new Car(car_no, customer_id, company, car_model, car_age);
			Customer cust=new Customer(customer_id, cname, addr, email);
			dao.add(car);
			cDao.add(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("main.html");
		rd.forward(request, response);
	}

}
