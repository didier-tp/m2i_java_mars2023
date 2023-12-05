package tp;

public class Personne {
	public String nom;
	public String prenom;
	//public int age; // l'age en "int" peut valoir 0 , 12 ou 30 mais pas null
	public Integer age; //l'age en tant qu'instance de la classe Integer
	             //peut valoir 0 , 12 ,30 ou la valeur null 
	             //null signifie "valeur pas renseignée" en base de donnée
	             //ou bien pas saisie dans une formulaire
	
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
	
	
	

}
