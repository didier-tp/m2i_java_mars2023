package tp;

public class Personne {
	
	public String nom;
	public String prenom;
	public int age;
	
	public void incremenerAge() {
		this.age = this.age + 1;
	}
	
	public String nomComplet() {
		return this.prenom + " " + this.nom; //retourner à peu près la con concaténation du premom et du nom
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	
}
