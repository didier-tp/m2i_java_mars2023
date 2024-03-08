package tp;

import java.sql.Connection;
import java.util.List;

import tp.dao.PersonneDao;
import tp.dao.PersonneDaoJdbc;
import tp.data.Personne;

public class MyApp {

	public static void main(String[] args) {
	     //essaiConnexion();
		//relancer si besoin le script qui ré-initialise la table entre 2 essais
		
		essaiUpdatePersonne();//mise à jour personne1
		essaiGetAllPersonnes();//afficher tout dont personne1 modifiée
		essaiGetPersonneById();//afficher que personne1
		//essaiDeletePersonne();//supprimer personne id=2
		essaiInsertPersonne();
		essaiInsertPersonne();
		essaiGetAllPersonnes();//réafficher tout ce qui reste ou qu'il ya en plus
	}
	

	public static void essaiUpdatePersonne() {
		PersonneDao personneDao = new PersonneDaoJdbc();
		Personne pers1Modifiee = new Personne(1,"alex_therieur" , 50 , 72.0);
		personneDao.updatePersonne(pers1Modifiee);
	}
	
	public static void essaiInsertPersonne() {
		PersonneDao personneDao = new PersonneDaoJdbc();
		Personne nouvellePersonne = new Personne(null,"nouveau_nom" , 0 , 3.3);
		personneDao.saveNew(nouvellePersonne);
	}
	
	public static void essaiGetPersonneById() {
		PersonneDao personneDao = new PersonneDaoJdbc();
		Personne personne1 = personneDao.getPersonneById(1);
		System.out.println("personne1="+personne1);
	}
	
	public static void essaiDeletePersonne() {
		PersonneDao personneDao = new PersonneDaoJdbc();
		personneDao.deletePersonne(2);
		System.out.println("personne avec id=2 normalement supprimée dans la table personne");
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
