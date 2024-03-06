package tp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zoo {
    private String nom;
    private List<Animal> listeAnimaux = new ArrayList<>();
    
    public void ajouterAnimal(Animal a) {
    	//appler la méthode qui ajoute sur this.
        this.listeAnimaux.add(a);
    }
    
    public void afficher() {
    	//afficher le nom du zoo
    	System.out.println("Zoo nom="+this.nom);
    	//afficher le nombre d'animaux dans le zoo
    	System.out.println("nombre d'animaux="+this.listeAnimaux.size());
    	
    	ComparateurDeAnimal comparateurDeAnimal = new ComparateurDeAnimal();
    	Collections.sort(listeAnimaux,comparateurDeAnimal);
    	
    	//afficher en boucle chaque animal du zoo (en appelant dessus .toString() ou bien .afficher()
    	System.out.println("animaux du Zoo et leurs façons de partler:");
    	for(Animal animal : this.listeAnimaux) {
    		//POLYMORPHISME en boucle sur .toString() et .parler()
    		System.out.print("\t" + animal.toString() + " qui parle comme ça : " );
    		animal.parler();
    	}
    	
    }

	public Zoo(String nom) {
		super();
		this.nom = nom;
	}
	
	public Zoo() {
		this("SuperZoo");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Animal> getListeAnimaux() {
		return listeAnimaux;
	}

	public void setListeAnimaux(List<Animal> listeAnimaux) {
		this.listeAnimaux = listeAnimaux;
	}
    
    
	
}
