package tp;

public class Personne {
	
	//public Integer numero; //clef primaire (pk / primary key) , avant le auto_increment = null (pas encore connu avant le INSERT SQL)
	public String nom;
	public String prenom;
	//public int age;  //valeur par défaut =0 et null impossible
	public Integer age; //null possible et valeur par defaut = null
	
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
