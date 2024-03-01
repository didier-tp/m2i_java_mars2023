package tp;

//Le code (interne) de la classe Compte est dans ce fichier (Compte.java)
//Le code d'utilisation de la classe Compte sera dans d'autres fichiers (ex: MyApp.java)

public class Compte {
	//données internes (attributs , propriétés, fields, variables d'instance)
	public String numero;
	public double solde;
	
	//traitements/fonctions internes (operations/méthodes):
	public void crediter(double montant) {
		this.solde = this.solde + montant;
		//solde = solde + montant;
	}
	
	public void debiter(double montant) {
		this.solde = this.solde - montant;
	}

}
