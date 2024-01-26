package tp;

import java.util.List;

public class MyApp {
	
	Stat stat;
	List<Produit> listeProduits;
	MyCsvUtil csvUtil = new MyCsvUtil();

	public static void main(String[] args) {
		MyApp myApp = new MyApp();
		myApp.loadProducts();
		myApp.computeStats();
		myApp.writeStats();
	}
	
	private void loadProducts(){
		this.listeProduits = csvUtil.readProductFile();
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

}
