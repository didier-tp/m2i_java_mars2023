package tp.pers;

import tp.Transportable;

public class Personne /* extends Object */ implements Transportable{
	
	//public Integer numero; //clef primaire (pk / primary key) , avant le auto_increment = null (pas encore connu avant le INSERT SQL)
	protected String nom;
	private String prenom;
	//public int age;  //valeur par défaut =0 et null impossible
	private Integer age; //null possible et valeur par defaut = null
	
	private double poids;
	private double volume;
	
	//A FAIRE en TP: ajouter une constante AGE_MAJORITE valant 18
	public static final int AGE_MAJORITE=18;
	
	//A FAIRE en TP: ajouter en static et get/set
	//esperanceDeVieHomme , esperanceDeVieFemme
	private static double esperanceDeVieHomme=79.3;
	private static double esperanceDeVieFemme=85.3;
	
	
	public Personne(String nom, String prenom, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	

	public Personne() {
		this("?","?",0);//nom, prenom, age
	}

	public boolean estMajeur() {
		return (this.age>=Personne.AGE_MAJORITE);
	}

	public void incremeterAge() {
		this.age = this.age + 1;
	}
	
	public String nomComplet() {
		return this.prenom + " " + this.nom; //retourner à peu près la con concaténation du premom et du nom
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	public void afficher() {
		System.out.println(">>>" + this.toString());
	}
	
	public String listeOccupations() {
		return "dormir;manger;loisirs";
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
		if(age<0) 
			System.err.println("age négatif invalide , pas pris en compte");
		else
		   this.age = age;
	}



	public static double getEsperanceDeVieHomme() {
		return esperanceDeVieHomme;
	}



	public static void setEsperanceDeVieHomme(double esperanceDeVieHomme) {
		Personne.esperanceDeVieHomme = esperanceDeVieHomme;
	}



	public static double getEsperanceDeVieFemme() {
		return esperanceDeVieFemme;
	}



	public static void setEsperanceDeVieFemme(double esperanceDeVieFemme) {
		Personne.esperanceDeVieFemme = esperanceDeVieFemme;
	}



	



	public void setPoids(double poids) {
		this.poids = poids;
	}



	public void setVolume(double volume) {
		this.volume = volume;
	}



	@Override
	public double getPoids() {
		return this.poids;
	}



	@Override
	public double getVolume() {
		return this.volume;
	}



	@Override
	public boolean estFragile() {
		return true;
	}






	
}
