package com.training.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiceLog
 */
public class ServiceLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceLog() {
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
		String customer_id=request.getParameter("customer_id");
		String uri="http://localhost:8080/Car_Service_REST_Services/rest/carservice/getService/"+customer_id;                 
		HttpURLConnection conn=null;
		BufferedReader reader=null;
        try{  
            //Declare the connection to weather api url
            URL url = new URL(uri);  
            conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
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
            request.setAttribute("logs", strBuf);
            RequestDispatcher rd=request.getRequestDispatcher("showLog.jsp");
            rd.forward(request, response);
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
