package in.biswa.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {

	static {
		//Load and register the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/smartprogramming";
		String user = "root";
		String password = "fyzQ$561";
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void closeResource(ResultSet resultSet, PreparedStatement statement, Connection connection) throws SQLException {
		if(resultSet != null) {
			resultSet.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
}
