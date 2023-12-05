package tp;

public class Personne {
	private String nom;
	private String prenom;
	//private int age; // l'age en "int" peut valoir 0 , 12 ou 30 mais pas null
	private Integer age; //l'age en tant qu'instance de la classe Integer
	             //peut valoir 0 , 12 ,30 ou la valeur null 
	             //null signifie "valeur pas renseignée" en base de donnée
	             //ou bien pas saisie dans une formulaire
	
	public Personne(String nom, String prenom, Integer age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
    }
	
	
	
	public Personne() {
		this("","",0);
	}


	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	


	//méthode à appeler à chaque anniversaire
	public void incrementerAge() {
		this.age = this.age + 1;
	}
	
	//methode qui renvoie true si majeur , false sinon
	public boolean estMajeur() {
		return (this.age >= 18);
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
		if(age>=0 && age <=150 )
		    this.age = age;
		else
			System.err.println("age trop petit ou trop grand ");
	}
	
	
	
	

}
