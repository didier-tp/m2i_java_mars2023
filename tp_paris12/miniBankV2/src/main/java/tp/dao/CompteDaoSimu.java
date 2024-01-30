package tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.data.Autorisation;
import tp.data.Compte;

public class CompteDaoSimu implements CompteDao {
	
	private Map<Integer , Compte> mapComptesByNum = new HashMap<>();
	
	private static CompteDaoSimu uniqueInstance = null;
	
	public static CompteDaoSimu getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance=new CompteDaoSimu();
		}
		return uniqueInstance;
	}
	

	@Override
	public Compte getCompteByNum(int num) {
		return mapComptesByNum.get(num);
	}

	@Override
	public List<Compte> getAllCompte() {
		return new ArrayList<Compte>(mapComptesByNum.values());
	}
	
	public CompteDaoSimu(){
		//constructeur à peaufiner en Tp:
		//créer 4 comptes numérotés de 1 à 4 et les enregistrer dans la map
		
		Compte c1 = new Compte(1,"compte 1", 100.0);//avec autorisation à 0.0 par defaut
		mapComptesByNum.put(c1.getNumero(), c1);
		
		Compte c2 = new Compte(2,"compte 2", 50.0, new Autorisation(150.0));//avec autorisation de découvert à 150.0		
		mapComptesByNum.put(c2.getNumero(), c2);
		
		Compte c3 = new Compte(3,"compte 3", 200.0);//avec autorisation à 0.0 par defaut
		//Compte c3 = new Compte(3,"compte 3", 200.0 , new Autorisation(100.0));//avec autorisation à 100.0 par defaut
		mapComptesByNum.put(c3.getNumero(), c3);
		
		Compte c4 = new Compte(4,"compte 4'", 50.0, new Autorisation(50.0));//avec autorisation de découvert à 50.0		
		mapComptesByNum.put(c4.getNumero(), c4);
	}

}
