package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion {

	public static Connection con = null;


	public static Connection getCon() {
		try {
			if (con == null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSI22", "root", "");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connexion ");
		return con;
	}
	
   

}

