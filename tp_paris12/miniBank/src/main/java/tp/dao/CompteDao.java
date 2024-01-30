package tp.dao;

import java.util.List;

import tp.data.Compte;

public interface CompteDao {
	public Compte getCompteByNum(int num);
	public List<Compte> getAllCompte();
}
