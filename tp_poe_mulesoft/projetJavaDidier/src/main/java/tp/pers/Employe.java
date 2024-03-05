package tp.pers;

//Employe hérite de Personne
//Employe est une sorte (ou cas particulier) de Personne 
public class Employe extends Personne {
	private String fonction; //ex: "developpeur" ou "comptable" ou ...
	private double salaire;
	
	public Employe(String nom, String prenom, Integer age, String fonction, double salaire) {
		super(nom, prenom, age);
		this.fonction = fonction;
		this.salaire = salaire;
	}
	
	public Employe() {
		this("?","?",0,"?",0.0);//nom,prenom,age,fonction,salaire
		//super("?","?",0); this.fonction="?"; this.salaire = 0.0;
		//super();//this.fonction vaudra null par defaut car String et this.salaire vaudra 0.0 par defaut car double
	}
	
	/*
	public Employe(Personne p){
		this(p.getNom(),p.getPrenom(),p.getAge(),"?",0.0);
	}
    */

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
