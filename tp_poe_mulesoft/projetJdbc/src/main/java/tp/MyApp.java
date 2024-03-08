package tp;

import java.sql.Connection;

public class MyApp {

	public static void main(String[] args) {
	     essaiConnexion();

	}
	
	public static void essaiConnexion() {
		ConnexionUtil connexionUtil =new ConnexionUtil();
		Connection cn = connexionUtil.etablirConnexion();
		System.out.println("cn="+cn);
	}

}
