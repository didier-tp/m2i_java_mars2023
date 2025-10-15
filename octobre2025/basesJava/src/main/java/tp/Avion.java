package tp;

import java.util.ArrayList;
import java.util.List;

import tp.pers.Employe;
import tp.pers.Personne;

public class Avion  extends ObjectVolant{
	
	private String nom;
	private List<Personne> personnes = new ArrayList<>();
	private List<Transportable> chosesTransportables = new ArrayList<>();
	
	public void addPersonne(Personne p){
		this.personnes.add(p);
	}
	
	public void addChoseTransportable(Transportable t){
		this.chosesTransportables.add(t);
	}
	
	public void initialiser() {
		this.nom="avion de ligne";
		this.setCouleur("beige");
		
		this.addChoseTransportable(new Personne("passager clandestin",45,85.0));
		this.addChoseTransportable(new Bagage("valise en carton",15.0,10.9));
		this.addChoseTransportable(new Bagage("sac",5.0,15.9));
		
		this.addPersonne(new Employe("pilote",55,88.9,5000.0));
		this.addPersonne(new Employe("hotesse 1",45,68.9,3000.0));
		this.addPersonne(new Personne("passager 1",65,98.9));
		this.addPersonne(new Personne("passager 2",45,68.9));
	}
	
	public void afficher() {
		System.out.println(this.nom + " avec couleur=" + this.getCouleur()+ " et avec plafond=" + this.getPlafond());
		/*
		for(Personne p : this.personnes) { //boucle for au sens forEach
			p.afficher(); //polymorphisme en boucle: déclenchera .afficher() et .toString()
			              //de la classe Personne ou bien Employe ou ...
		}
		*/
		System.out.println("contenu de l'avion:");
		System.out.println("\tliste des personnes:");
		for(Personne p : this.personnes)
			System.out.println("\t\t"+p.toString());
		System.out.println("\tliste des choses Transportables (dans la soute):");
		double poidsTotal = 0.0;
		for(Transportable t : this.chosesTransportables) {
			System.out.println("\t\t"+t.getDesignation());
			poidsTotal+= t.getPoids();
		}
		System.out.println("\tpoidsTotal des choses Transportables (dans la soute):" + poidsTotal);
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
