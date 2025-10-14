package tp;

import java.util.ArrayList;
import java.util.List;

public class Avion  extends ObjectVolant{
	
	private String nom;
	private List<Personne> personnes = new ArrayList<>();
	
	public void addPersonne(Personne p){
		this.personnes.add(p);
	}
	
	public void initialiser() {
		this.nom="avion de ligne";
		this.setCouleur("beige");
		this.addPersonne(new Personne("passager clandestin",45,78.9));
		this.addPersonne(new Employe("pilote",55,88.9,5000.0));
		this.addPersonne(new Employe("hotesse 1",45,68.9,3000.0));
	}
	
	public void afficher() {
		System.out.println(this.nom + " avec couleur=" + this.getCouleur()+ " et avec plafond=" + this.getPlafond());
		for(Personne p : this.personnes) { //boucle for au sens forEach
			p.afficher(); //polymorphisme en boucle: déclenchera .afficher() et .toString()
			              //de la classe Personne ou bien Employe ou ...
		}
	}

	@Override
	public int getPlafond() {
		return 10000; //avion de ligne ordinaire pouvant voler jusqu'à 10km d'altitude (10000m)
	}
	
	/*le main() appelera testAvion(){
	 Avion a1 = new Avion();
	 a1.initialiser()
	 a1.afficher();
	 }
	 */
	

}
