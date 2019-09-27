package com.sitrus;

import java.util.Scanner;
import java.sql.*;


public class ConnectionManager {
	
	static final String URL = "jdbc:mysql://den1.mysql6.gear.host:3306/sitrususers";
	static final String USERNAME = "sitrususers";
	static final String PASSWORD = "sitrususers!";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection was made");
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return conn;
	}

/****************** Main ***************************/
	
//	public static void main(String[] args) throws SQLException {
//		
//		Connection conn = ConnectionManager.getConnection();
//		
//		
//		
//		
///****************** Close Connection ********************/
//		
//		try {
//			conn.close();
//			System.out.println("Connection was closed");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
}
