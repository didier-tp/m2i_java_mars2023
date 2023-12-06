package tp.pers;

public class Employe extends Personne{
	private Double salaire;
	private String fonction;
	
	
	
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
	
	public Employe(String nom, String prenom, Integer age,String fonction,Double salaire) {
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


	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	
	
}
