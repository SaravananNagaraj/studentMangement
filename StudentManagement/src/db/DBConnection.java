package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	static Connection con;
	
	public static Connection createConnection() {
		
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			String user = "root";
			String password = "S1995@sara#";
			String url = "jdbc:mysql://localhost:3306/student_management?autoReconnect=true&useSSL=false";
			
			con = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
