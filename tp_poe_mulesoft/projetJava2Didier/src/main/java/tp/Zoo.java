package tp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    	
    	/*
    	//V1 avec comparateur et sans lambda expression
    	ComparateurDeAnimal comparateurDeAnimal = new ComparateurDeAnimal();
    	Collections.sort(listeAnimaux,comparateurDeAnimal);
    	*/
    	/*
    	//V2: avec lambda expression (depuis java 8)
    	//Collections.sort(listeAnimaux,(a1,a2)->{return (int)(a1.getPoids() - a2.getPoids()); } );
    	//Collections.sort(listeAnimaux,(a1,a2)-> (int)(a1.getPoids() - a1.getPoids()) );
    	Collections.sort(listeAnimaux,(a1,a2)-> a1.getCouleur().compareTo(a2.getCouleur()) );
    	*/
    	
    	//V3 avec .stream() pour enchainer , filtrage , tri et transformation
    	listeAnimaux= 
    	  listeAnimaux.stream()
    	     .filter( (a) -> a.getPoids() <= 5.0)
    	     .sorted((a1,a2)-> Double.compare(a1.getPoids() , a2.getPoids()))
    	     .map((a)-> { a.setCouleur(a.getCouleur().toUpperCase()); return a; } )
    	     .collect(Collectors.toList());
    	
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
