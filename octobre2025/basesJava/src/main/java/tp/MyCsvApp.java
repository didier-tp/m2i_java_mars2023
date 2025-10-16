package tp;

import java.util.List;

public class MyCsvApp {
	
	public static void main(String[] args) {
		  MyCsvUtil myCsvUtil = new MyCsvUtil();
		  List<Produit> listeProduits = myCsvUtil.readFile("produits.csv");
		  //calcul de Stat
		  myCsvUtil.writeStatFile(null /* stat */, "stats.csv");
	}

}
