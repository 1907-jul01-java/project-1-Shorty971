

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private Connection connection;
	private String url;
	private String user;
	private String password;
	
	
	ConnectionUtil() {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/postgres","postgres","password");
			System.out.print(this.connection);
		}
		catch(SQLException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	public Connection getconnection() {
		return connection;
	}
	
	public void close() {
		try {
			this.connection.close();
		}
		catch(SQLException e) {	
		}
	}
}
