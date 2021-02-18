package com.freetuition.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostresqlConnection {

	public static Connection getConnection() throws ClassNotFoundException {

		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(
					System.getenv("postgresURL"), 
					System.getenv("postgresUsername"),
					System.getenv("postgresPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
