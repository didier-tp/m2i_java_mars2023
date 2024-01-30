package tp;

import tp.dao.CompteDao;
import tp.dao.CompteDaoSimu;
import tp.data.Compte;
import tp.exception.BankException;
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
		System.out.println("avant virement  c1="+c1);
		System.out.println("avant virement  c2="+c2);
		
		serviceComptes.effectuerVirement(25.0, 1, 2); //virement de 25.0 du compte 1 vers le compte 2
		
		//a faire en TP:
		//afficher les valeurs des comptes c1 et c2 après le virement
		System.out.println("après virement  c1="+c1);
		System.out.println("apres virement  c2="+c2);
		
		//a faire en TP (phase 2)
		//effectuer des virements autorisés ou pas au sein d'un try/catch
		
		Compte c3 = compteDao.getCompteByNum(3);
		Compte c4 = compteDao.getCompteByNum(4);

		System.out.println("avant tentative de virement  c3="+c3);
		System.out.println("avant tentative de virement  c4="+c4);
		
		try {
			serviceComptes.effectuerVirement(250.0, 3, 4); //virement de 250.0 du compte 3 vers le compte 4
		} catch (BankException e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}

		System.out.println("après tentative de virement  c3="+c3);
		System.out.println("apres tentative de virement  c4="+c4);
		
	}

}
