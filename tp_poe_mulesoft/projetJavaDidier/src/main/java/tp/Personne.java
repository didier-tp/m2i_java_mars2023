package tp;

public class Personne {
	
	//public Integer numero; //clef primaire (pk / primary key) , avant le auto_increment = null (pas encore connu avant le INSERT SQL)
	private String nom;
	private String prenom;
	//public int age;  //valeur par défaut =0 et null impossible
	private Integer age; //null possible et valeur par defaut = null
	
	
	
	
	public Personne(String nom, String prenom, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	

	public Personne() {
		this("?","?",0);//nom, prenom, age
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
	
	
	
	
}
