package tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.Produit;

public class ProduitDaoMap implements ProduitDAO {
	
	private int lastNum=0;
	private Map<Integer,Produit> mapNumeroProduit = new HashMap<>(); 

	@Override
	public Produit createProduit(Produit p) {
		this.lastNum++; //simuler auto_incr
		p.setNumero(this.lastNum);
		this.mapNumeroProduit.put(p.getNumero(), p);
		return p; //retourne le produit avec le numero
	}

	@Override
	public Produit findById(int numero) {
			return this.mapNumeroProduit.get(mapNumeroProduit);
	}

	@Override
	public List<Produit> findAll() {
		return new ArrayList<Produit>(this.mapNumeroProduit.values());
	}

	@Override
	public void updateProduit(Produit p) {
		this.mapNumeroProduit.put(p.getNumero(), p);
	}

	@Override
	public void deleteById(int numero) {
		this.mapNumeroProduit.remove(numero);
	}

}
