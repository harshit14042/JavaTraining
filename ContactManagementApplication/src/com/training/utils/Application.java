package com.training.utils;

import java.sql.Connection;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=DbConnections.getConnection();
		DAO dao=new DAOImpl(conn);
		
		
	}

}
