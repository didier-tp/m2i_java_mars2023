package tp;

import java.util.List;

public class MyCsvApp {
	
	public static void main(String[] args) {
		  MyCsvUtil myCsvUtil = new MyCsvUtil();
		  List<Produit> listeProduits = myCsvUtil.readFile("produits.csv");
		  Stat stat = new Stat();
		  stat.setNbProduits(listeProduits.size());
		  double totalPrix=0;
		  double totalPoids=0;
		  for(Produit p : listeProduits) {
			  totalPrix += p.getPrix();
			  totalPoids += p.getPoids();
		  }
		  stat.setMoyennePrix(totalPrix/listeProduits.size());
		  stat.setMoyennePoids(totalPoids/listeProduits.size());
		  System.out.println("stat="+stat);
		  myCsvUtil.writeStatFile( stat , "stats.csv");
	}

}
