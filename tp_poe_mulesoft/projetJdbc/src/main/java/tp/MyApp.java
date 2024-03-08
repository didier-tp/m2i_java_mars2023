package tp;

import java.sql.Connection;
import java.util.List;

import tp.dao.PersonneDao;
import tp.dao.PersonneDaoJdbc;
import tp.data.Personne;

public class MyApp {

	public static void main(String[] args) {
	     //essaiConnexion();
		essaiGetAllPersonnes();
	}
	
	public static void essaiGetAllPersonnes() {
		PersonneDao personneDao = new PersonneDaoJdbc();
		List<Personne> personnes = personneDao.getAllPersonnes();
		System.out.println("personnes="+personnes);
	}
	
	public static void essaiConnexion() {
		ConnexionUtil connexionUtil =new ConnexionUtil();
		Connection cn = connexionUtil.etablirConnexion();
		System.out.println("cn="+cn);
	}

}
