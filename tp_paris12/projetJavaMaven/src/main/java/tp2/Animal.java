package tp2;

public abstract class Animal /* extends Object */{
    private String couleur;
    private Double poids;
    
    /*
    public void parler() {
    	System.out.println("l'animal parle ..."); //ancien code temporaire
    }
    */
    public abstract void parler(); //méthode abstraite sans code entre { }
    
    public void afficher() {
    	System.out.println("animal="+this.toString());
    }

    //toString() généré par assistant
	@Override
	public String toString() {
		return "Animal [couleur=" + couleur + ", poids=" + poids + "]";
	}
	
	//get/set, constructeurs
	public Animal() {
		super();
	}
	
	public Animal(String couleur, Double poids) {
		super();
		this.couleur = couleur;
		this.poids = poids;
	}


	public String getCouleur() {
		return couleur;
	}

	

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}
    
    
	
    
}
