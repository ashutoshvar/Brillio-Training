package com.jdbc.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
	static Connection conn;
	
	public static Connection createConnection() throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Lmaoyougaynow69super100");
		return conn;
	}

	public static void closeConnection() throws SQLException{
	conn.close();
	}
}
