package tp;

import tp.dao.CompteDao;
import tp.dao.CompteDaoSimu;
import tp.data.Compte;
import tp.service.ServiceComptes;

public class MyApp {

	public static void main(String[] args) {
		testVirement();
	}
	
	public static void testVirement() {
		System.out.println("testVirement");
		CompteDao compteDao = CompteDaoSimu.getInstance();
		ServiceComptes serviceComptes = ServiceComptes.getInstance();
		
		Compte c1 = compteDao.getCompteByNum(1);
		Compte c2 = compteDao.getCompteByNum(2);
		//a faire en TP:
		//afficher les valeurs des comptes c1 et c2 avant le virement
		
		
		serviceComptes.effectuerVirement(25.0, 1, 2); //virement de 25.0 du compte 1 vers le compte 2
		
		//a faire en TP:
		//afficher les valeurs des comptes c1 et c2 après le virement
		
		//a faire en TP (phase 2)
		//effectuer des virements autorisés ou pas au sein d'un try/catch
		
	}

}
