package by.gsu.epamlab.db;

import java.sql.*;

public class ConnectionBase {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/webstore", "artur", "123");
	}
	
	public static void closeResultSet(ResultSet ... resultSets) {
		for (ResultSet resultSet : resultSets) {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					System.err.println("Resource closing problem : " + e);
				}
			}
		}
	}
	
	public static void closeStatement(Statement ... statements) {
		for (Statement statemet : statements) {
			if (statemet != null) {
				try {
					statemet.close();
				} catch (SQLException e) {
					System.err.println("Resource closing problem : " + e);
				}
			}
		}
	}
	
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Resource closing problem : " + e);
			}
		}		
	}
}