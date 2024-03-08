package tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnexionUtil {
	
	public static Connection etablirConnexion() {
		Connection cn =null;
		ResourceBundle ressources = ResourceBundle.getBundle("paramDB") ; // paramDB.properties
		String driver = ressources.getString("driver");
		String chUrl = ressources.getString("url");
		String username = ressources.getString("username");
		String password = ressources.getString("password");
		try {
			Class.forName(driver); 
			cn = DriverManager.getConnection(chUrl,username,password) ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}

}
