package tp.service;

import tp.dao.CompteDao;
import tp.dao.CompteDaoSimu;
import tp.exception.BankException;

public class ServiceComptes {
	
    private static ServiceComptes uniqueInstance = null;
	
	public static ServiceComptes getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance=new ServiceComptes();
		}
		return uniqueInstance;
	}
	
	private CompteDao compteDao = CompteDaoSimu.getInstance(); //singleton sans get/set
	
	public void effectuerVirement(double montant,int numCptDebit,int numCptCredit)
	   throws BankException{
		//à coder en s'appuyant sur compteDao et compte (et Automrisation) 
		//et tester en Tp via MyApp.testVirement()
	}
}
