package tp;

public class Employe extends Personne {
	private String fonction;
	private Double salaire;
	
	
	
	@Override
	public String toString() {
		return "Employe [fonction=" + fonction + ", salaire=" + salaire + "]"
				+ " héritant de " + super.toString();
	}
	
	/*
	public void afficher() {
		super.afficher();
		System.out.println("    Personne de type employe avec fonction="
		   +fonction +  " et salaire=" + salaire);
	}
	*/
	
	
	public String listeOccupations() {
		//return "dormir;manger;loisir;TRAVAILLER";
		return super.listeOccupations() + ";TRAVAILLER";
	}
	
	
	
	public Employe(String nom,String prenom,String fonction, Double salaire) {
		super(nom,prenom);
		this.fonction = fonction;
		this.salaire = salaire;
	}

	public Employe() {
		super(); //pour un homme ordinaire , l'essence c'est super
		//plus sérieusement: appel du constructeur hérité avec 0 paramètre
	}


	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	
	
}
