package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
	
	private static final String url = "jdbc:h2:~/users";
	private static final String user = "sa";
	private static final String password = "";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
	}
	
}
