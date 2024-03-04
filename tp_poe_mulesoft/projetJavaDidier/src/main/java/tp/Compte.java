package tp;

import java.util.Objects;

//Le code (interne) de la classe Compte est dans ce fichier (Compte.java)
//Le code d'utilisation de la classe Compte sera dans d'autres fichiers (ex: MyApp.java)

public class Compte {
	//données internes (attributs , propriétés, fields, variables d'instance)
	private String numero;//null  par defaut
	private double solde; //0.0 par defaut
	
	//Rappel : "static" pour que la valeur de decouvertMaximumCommun
	//soit la même pour toutes les instances de cette classe Compte
    private static double decouvertMaximumCommun = -500.0;
    //avec .get/.set static générés par assistants

	public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		//this.solde = solde;
		this.setSolde(solde);
	}


	public Compte() {
		this("0",0.0);
	}

	
	


	public static double getDecouvertMaximumCommun() {
		return decouvertMaximumCommun;
	}


	public static void setDecouvertMaximumCommun(double decouvertMaximumCommun) {
		Compte.decouvertMaximumCommun = decouvertMaximumCommun;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numero, solde);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(numero, other.numero)
				&& Double.doubleToLongBits(solde) == Double.doubleToLongBits(other.solde);
	}


	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + "]";
	}


	//traitements/fonctions internes (operations/méthodes):
	public void crediter(double montant) {
		this.solde = this.solde + montant;
		//solde = solde + montant;
	}
	
	public void debiter(double montant) {
		this.solde = this.solde - montant;
	}

	

	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		if(solde < -100000000)
			//throw new RuntimeException("solde trop petit pas accepté");
			System.err.println("solde trop petit pas accepté");
		else 
		    this.solde = solde;
	}
}
