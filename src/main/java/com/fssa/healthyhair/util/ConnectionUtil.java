package com.fssa.healthyhair.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {

		String dbUrl;
		String dbUser;
		String dbPassword;

		// Cloud DB
//		dbUrl = System.getenv("DB_URL");
//		dbUser = System.getenv("DB_USER");
//		dbPassword = System.getenv("DB_PASSWORD");
//		
		dbUrl = "jdbc:mysql://localhost:3306/gopikannan_saravanan_corejava_project";
		dbUser = "root";
		dbPassword = "123456";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);

		} catch (SQLException e) {
			System.err.print(e);
			throw new RuntimeException("Unable to connect database", e);
		} catch (ClassNotFoundException e) {
			System.err.print(e);
			throw new RuntimeException("Database driver class not found", e);

		}
	}

}
