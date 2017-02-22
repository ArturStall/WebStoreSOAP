package by.gsu.epamlab.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCostDB {
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private ResultSet resultSet = null;
	
	public synchronized int getCostProduct(int idProduct) {		
		try {			
			connection = ConnectionBase.getConnection();
			pStatement = connection.prepareStatement("SELECT * FROM products WHERE idProduct = ?");
			pStatement.setInt(1, idProduct);
			resultSet = pStatement.executeQuery();
			resultSet.next();
			int cost = resultSet.getInt("cost");
			return cost;
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {			
			ConnectionBase.closeResultSet(resultSet);
			ConnectionBase.closeStatement(pStatement);
			ConnectionBase.closeConnection(connection);
		}
	}
}