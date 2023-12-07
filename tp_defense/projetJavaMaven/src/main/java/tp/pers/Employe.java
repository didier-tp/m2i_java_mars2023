package tp.pers;

public class Employe extends Personne{
	//enumeration "Fonction" = type de données
	//ne pouvant prendre que quelques valeurs possibles
	public enum Fonction { PROGRAMMEUR ,COMPTABLE , VENDEUR , PILOTE , HOTESSE };
	
	
	private Double salaire;
	//private String fonction;
	private Fonction fonction;
	
	
	
	@Override
	public String toString() {
		return "Employe [salaire=" + salaire + ", fonction=" + fonction + "]"
				+ "\n\t en tant que cas particulier de " + super.toString();
	}
	
	
	

	public Employe() {
		super();
	}


	public Employe(String nom, String prenom, Integer age) {
		super(nom, prenom, age);
	}
	
	public Employe(String nom, String prenom, Integer age,Fonction fonction,Double salaire) {
		super(nom, prenom, age);
		this.fonction=fonction;
		this.salaire=salaire;
	}
   


	public Double getSalaire() {
		return salaire;
	}


	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}


	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	
}
