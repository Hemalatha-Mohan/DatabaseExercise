package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://10.30.1.64:3306/hemalamo?characterEncoding=utf8&useSSL=false&useUnicode=true";
	private static final String USERNAME = "hemalamo";
	private static final String PASSWORD = "123";
	
	public DatabaseConnection(){
		try {
			Class.forName(DRIVER_PATH);
			
		}catch(Exception e) {
			
			throw new RuntimeException("Something went wrong");
			
		}
		
		
	}//End of constructor
	
	public Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
	}//End of getConnection
}
