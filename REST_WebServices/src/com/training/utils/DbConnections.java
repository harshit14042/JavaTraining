package com.training.utils;
import java.sql.*;
import java.io.*;
import java.util.*;
public class DbConnections {
	
	public static Connection getConnection(InputStream inStream){
		Connection conn=null;
		
		try {
			Properties props=new Properties();
			props.load(inStream);
			Class.forName(props.getProperty("db.driverClass"));
			String url=props.getProperty("db.url");
			String user=props.getProperty("db.userName");
			String password=props.getProperty("db.passWord");
			conn=DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
}
