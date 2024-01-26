package tp;

import java.util.List;
import java.util.stream.Collectors;

public class MyApp {
	
	Stat stat;
	List<Produit> listeProduits;
	MyCsvUtil csvUtil = new MyCsvUtil();

	public static void main(String[] args) {
		MyApp myApp = new MyApp();
		myApp.loadProducts();
		myApp.computeStats();
		myApp.writeStats();
		myApp.writeSortedProducts();
	}
	
	private void loadProducts(){
		this.listeProduits = csvUtil.readProductFile();
	}
	
	private void sortProductsByPrice(){
		this.listeProduits = 
				this.listeProduits.stream()
				.sorted((p1,p2)->Double.compare(p1.getPrix(), p2.getPrix()))
				.collect(Collectors.toList());
	}
	
    private void computeStats(){
		int nbProd=0;
		double sommePrix=0.0;
		double sommePoids=0.0;
		for(Produit prod : this.listeProduits) {
			nbProd++;
			sommePrix += prod.getPrix();
			sommePoids += prod.getPoids();
		}
		this.stat = new Stat(nbProd,sommePrix/nbProd,sommePoids/nbProd);
	}
    
    private void writeStats(){
    	csvUtil.writeStatFile(stat);
	}
    
    private void writeSortedProducts() {
    	this.sortProductsByPrice();
    	csvUtil.writeProductFile(this.listeProduits,"produits_tries_par_prix.csv");
    }

}
