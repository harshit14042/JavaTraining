package com.training.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entity.Service_Log;
import com.training.utils.Service_LogDAOImpl;

/**
 * Servlet implementation class addService
 */
public class addService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addService() {
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
		Service_LogDAOImpl dao=null;
		long sid=1;
		try {
			dao=new Service_LogDAOImpl();
			sid=dao.getNewId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String customer_id=request.getParameter("customer_id");
		String car_no=request.getParameter("car_no");
		String services=request.getParameter("services");
		String service_date=request.getParameter("service_date");
		String delivery_date=request.getParameter("delivery_date");
		
		int serviceid=1;
		int net_amount=0;
		if(services.equals("polishing")) {
			net_amount=1000;
			serviceid=1;
		}
		else if(services.equals("wheelbalancing")) {
			net_amount=1200;
			serviceid=2;
		}
		else {
			net_amount=3000;
			serviceid=3;
		}
		String uri="http://localhost:8080/Insurance/rest/insurance/getDetails/"+customer_id;                 
		HttpURLConnection conn=null;
		BufferedReader reader=null;
        try{  
            //Declare the connection to weather api url
            URL url = new URL(uri);  
            conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                              + conn.getResponseCode());
            }
            
            //Read the content from the defined connection
            //Using IO Stream with Buffer raise highly the efficiency of IO
	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String output = "";
            String strBuf="";
            while ((output = reader.readLine()) != null)  
                strBuf+=(output);  
            System.out.println(output+" "+strBuf);
		int coverage=Integer.parseInt(strBuf);
		System.out.println(coverage);
		net_amount=coverage-net_amount;
		//Service_Log sl=new Service_Log(sid, car_no, service_date, delivery_date, net_amount, serviceid);
		}catch(Exception e) {
			e.printStackTrace();
		}
        try {
			dao.add(new Service_Log(sid, car_no, service_date, delivery_date, net_amount, serviceid));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("net_amount", net_amount);
        RequestDispatcher rd=request.getRequestDispatcher("dispAmount.jsp");
        rd.forward(request, response);
	}

}
