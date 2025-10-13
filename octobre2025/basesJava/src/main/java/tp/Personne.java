package tp;

public class Personne {
	
	public String nom;
	public Integer age;
	public Double poids;
	
	
	public void afficher(){
		System.out.println("Personne avec nom=" + this.nom +  " et age=" + this.age + " et poids=" + this.poids);
	}

}
