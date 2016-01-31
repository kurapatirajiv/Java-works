package com.tcs.ilp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	static String username = "H80ORAUSER2D";
	static String password = "tcshyd";
	static String url = "jdbc:oracle:thin:@172.25.192.71:1521:javadb";

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			if (connection == null) {
				connection = DriverManager.getConnection(url, username, password);
			} else {
				return connection;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeResources(Connection connection, ResultSet resultset,
			PreparedStatement preparedStatement) {
		try {
			if (connection != null)
				connection.close();
			if (resultset != null)
				resultset.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void closeResources(Connection connection, ResultSet resultset,
			Statement statement) {
		try {
			if (connection != null)
				connection.close();
			if (resultset != null)
				resultset.close();
			if (statement != null)
				statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
