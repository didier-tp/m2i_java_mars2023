package tp;

//Employe hérite de Personne
//Employe est une sorte (ou cas particulier) de Personne 
public class Employe extends Personne {
	private String fonction; //ex: "developpeur" ou "comptable" ou ...
	private double salaire;
	
	
	@Override
	public String listeOccupations() {
		//return "dormir;manger;loisirs;travailler";
		return super.listeOccupations() + ";travailler";
	}
	

	@Override
	public void afficher() {
		System.out.println("*** " + this.toString());
	}

	

	@Override
	public String toString() {
		return "Employe [fonction=" + fonction + ", salaire=" + salaire + "]"
				+ super.toString();
	}


	public String getFonction() {
		return fonction;
	}
	

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	
	
}
