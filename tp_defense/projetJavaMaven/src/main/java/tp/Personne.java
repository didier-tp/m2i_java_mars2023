package tp;

public class Personne /* extends Object */ implements Transportable {
	
	public static final int  AGE_MAJORITE=18; //constante
	public static final double  VOLUME_MOYEN=50.0; //constante
	
	//en Tp , esperanceVie en static et avec get/set
	
	//via le mot clef static , on précise que lorsque cette valeur changera,
	//elle changera en même temps pour toutes les intances de la classe Personne
	//on parle de variable de classe (pas spécifiqu à une instance précise)
	private static int esperanceVie=77; //valeur par defaut initiale
	
	private String nom;
	private String prenom;
	//private int age; // l'age en "int" peut valoir 0 , 12 ou 30 mais pas null
	private Integer age; //l'age en tant qu'instance de la classe Integer
	             //peut valoir 0 , 12 ,30 ou la valeur null 
	             //null signifie "valeur pas renseignée" en base de donnée
	             //ou bien pas saisie dans une formulaire
	private double poids=75;//75kg comme valeur par defaut
	
	@Override
	public double getVolume() {
		return VOLUME_MOYEN;
	}

	@Override
	public double getPoids() {
		return poids;
	}
	
	
	public void setPoids(double poids) {
		this.poids = poids;
	}

	public Personne(String nom, String prenom, Integer age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
    }
	
	public Personne() {
		this("","",0);
	}

	//methode qui renvoie true si majeur , false sinon
	public boolean estMajeur() {
		//return (this.age >= 18);
		//return (this.age >= Personne.AGE_MAJORITE);
		return (this.age >= AGE_MAJORITE);
	}

	


	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}

	//méthode à appeler à chaque anniversaire
	public void incrementerAge() {
		this.age = this.age + 1;
	}
	
	



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		if(age>=0 && age<=150 )
		    this.age = age;
		else
			System.err.println("age trop petit ou trop grand ");
	}

	public static int getEsperanceVie() {
		return esperanceVie;
	}

	public static void setEsperanceVie(int esperanceVie) {
		Personne.esperanceVie = esperanceVie;
	}

	
	


}
