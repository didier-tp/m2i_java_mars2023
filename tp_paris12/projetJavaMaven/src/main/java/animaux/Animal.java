package animaux;

/*
 * Animal a1 = new Animal("blanc",4.5); IMPOSSIBLE
 * mais
 * Animal a = new Chat() possible
 */

public abstract class Animal implements Transportable{
    private String couleur;
    private Double poids;
    
    //solution 1
    private static final Double VOLUME_MOYEN=10.0;
    //solution 2
    //private Double volume; //+get/set
    
    @Override
	public Double getVolume() {
		return VOLUME_MOYEN;
		//return vomume
	}

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
