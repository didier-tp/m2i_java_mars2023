package tp;

import java.sql.Connection;
import java.util.List;

import tp.dao.PersonneDao;
import tp.dao.PersonneDaoJdbc;
import tp.data.Personne;

public class MyApp {

	public static void main(String[] args) {
	     //essaiConnexion();
		essaiUpdatePersonne();
		essaiGetAllPersonnes();
	}
	

	public static void essaiUpdatePersonne() {
		PersonneDao personneDao = new PersonneDaoJdbc();
		Personne pers1Modifiee = new Personne(1,"alex_therieur" , 50 , 72.0);
		personneDao.updatePersonne(pers1Modifiee);
	}
	
	public static void essaiGetAllPersonnes() {
		PersonneDao personneDao = new PersonneDaoJdbc();
		//PersonneDao personneDao = new PersonneDaoJpa();
		List<Personne> personnes = personneDao.getAllPersonnes();
		System.out.println("personnes="+personnes);
	}
	
	public static void essaiConnexion() {
		Connection cn = ConnexionUtil.etablirConnexion();
		System.out.println("cn="+cn);
	}

}
