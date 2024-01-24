package tp;

import java.util.ArrayList;
import java.util.List;

public class Avion {
	
	private String nom;
	private Integer nbPlaces;
	private List<Personne> listePersonnes ;
	
	public void addPersonne(Personne p) {
		if(listePersonnes.size()<nbPlaces) {
			listePersonnes.add(p);
		}else
			System.out.println("plus de place, avion plein");
	}
	
	public void afficher() {
		System.out.println("avion nom="+nom + " nbPlaces=" + nbPlaces);
		System.out.println("nbPersonnes=" + listePersonnes.size());
		for(Personne p : listePersonnes) {
			System.out.println(p.toString()); //éventuel polymorphimse sur .toString()
			//Rappel: Employe = cas particulier de Personne
		}
	}
	
	
	public Avion(String nom, Integer nbPlaces) {
		super();
		this.nom = nom;
		this.nbPlaces = nbPlaces;
		this.listePersonnes = new ArrayList<>();
	}
	
	public Avion() {
	   this("avionQuiVole" , 120);
	}

	//+ tous les get/set
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public List<Personne> getListePersonnes() {
		return listePersonnes;
	}

	public void setListePersonnes(List<Personne> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}
	
	

}
