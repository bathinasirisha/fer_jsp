package com.rs.fer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() {
	
	Connection connection = null;
	try {

		// 1.Registering the Driver.
		Class.forName("com.mysql.jdbc.Driver");

		// 2. To get the connection from database to jdbc.
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer_jdbc", "root", "root");
	}
		catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}

		catch (SQLException s) {
			s.printStackTrace();
		}
		
		return connection;

}
	
	public static void closeConnection(Connection connection) {
		try {

			connection.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}	
	}
	}
