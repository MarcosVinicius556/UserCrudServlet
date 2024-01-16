package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Connection {
	
	private static final String url = "jdbc:h2:mem:testdb";
	private static final String user = "sa";
	private static final String password = "";
	private static Connection conn = null;
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.h2.Driver");
			if(conn == null) {
				conn = DriverManager.getConnection(url, user, password);
				
				/**
				 * Cria a tabela caso não exista
				 */
				Statement statement = conn.createStatement();
				statement.execute("CREATE TABLE IF NOT EXISTS user (id BIGINT PRIMARY KEY SERIAL, nome CHARACTER VARYING(128), cpf CHARACTER VARYING(11), nascimento CHARACTER VARYING(11), situacao CHARACTER VARYING(32))");
			}
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);
		}
	}
	
}
