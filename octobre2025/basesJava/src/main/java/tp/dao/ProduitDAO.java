package tp.dao;

import java.util.List;
import java.util.Optional;

import tp.Produit;

/*
 * DAO = Data Access Object 
 * avec méthode "CRUD" (Create : insert into ou ... , Rechercher : select , Update , Delete)
 */

public interface ProduitDAO {
	
	default Optional<Produit> findByIdOptional(int numero) { 
		return Optional.ofNullable(findById(numero)); 
	}
	
	Produit createProduit(Produit p); //en retour , le produit avec le numero souvent auto incrémenté
	Produit findById(int numero);
	List<Produit> findAll();
	void updateProduit(Produit p);
	void deleteById(int numero);  //en cas d'erreur ça pourrait retourner une exception RuntimeException
}
