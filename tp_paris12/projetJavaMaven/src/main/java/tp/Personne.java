package tp;

public class Personne {
	
	private String nom;
	private String prenom;
	//public int age;
	private Integer age=0; //null comme valeur possible si age inconnu
	private Double poids;
	
	//via le mot clef static , la valeur de l'espéranceDeVie
	//sera partagée par toutes les instances de la classe Personne
	private static Double esperanceDeVie=83.0;//83.0=valeur au lancement (qui peut changer)
	
	public static final int AGE_MAJORITE=18;  //constante (qui ne peut pas changer)
	
	public boolean estMajeur() {
		//return (this.age >= AGE_MAJORITE);
		//ou bien
		if(this.age >= AGE_MAJORITE) 
			return true;
		else 
			return false;
	}
	
	public Personne() {
		this.nom="nom inconnu";
		this.prenom="?";
	}
	
	
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public void afficher() {
		System.out.println("personne=" + this.toString());
	}
	
	public String listeOccupations() {
		return "dormir;manger;loisir";
	}
	


	public void incrementerAge() {
		if(age!=null)
		   this.age= this.age + 1;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", poids=" + poids + "]";
	}
	


	public Integer getAge() {
		return age;
	}


	//public void setAge(Integer age) throws IllegalParamException {
	public void setAge(Integer age) throws IllegalArgumentException {
		if(age <0) {
			//System.out.println("age négatif invalide");
			//throw new RuntimeException("age négatif invalide");
			throw new IllegalArgumentException("age négatif invalide");
			//throw new IllegalParamException("age négatif invalide");
		}
		else
		  this.age = age;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		if(  nom== null || nom.equals("")  ) {
			System.out.println("nom vide ou null invalide");
		}
		else
		   this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Double getPoids() {
		return poids;
	}


	public void setPoids(Double poids) {
		this.poids = poids;
	}


	public static Double getEsperanceDeVie() {
		return esperanceDeVie;
	}


	public static void setEsperanceDeVie(Double esperanceDeVie) {
		Personne.esperanceDeVie = esperanceDeVie;
	}
	
	
	
}
