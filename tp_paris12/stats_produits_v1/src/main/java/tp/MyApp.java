package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyApp {
	
	Stat stat;
	List<Produit> listeProduits;
	//Map<String , List<Produit>> mapSubListProdByCategorie ;
	//Map<String , Stat> mapStatsByCategorie ;
	
	MyCsvUtil csvUtil = new MyCsvUtil();

	public static void main(String[] args) {
		MyApp myApp = new MyApp();
		myApp.loadProducts();
		myApp.computeStats();
		//myApp.computeStatsByCategories();
		myApp.writeStats();
		//myApp.writeSortedProducts();
		//myApp.writeStatsByCategories();
	}
	
	

	private void computeStatsByCategories() {
		//Phase3 facultative
		
		//étape 1 : construire la table d'association nomCategorie , sousListeProduitsDeLaCategorie
		//mapSubListProdByCategorie = new HashMap<>();
		//à completer en tp
		
		//étape 2 : statitistiques pour chaque catégorie:
		//mapStatsByCategorie=new HashMap<>();
		//à completer en tp
	}

	private void loadProducts(){
		this.listeProduits = csvUtil.readProductFile();
	}
	
	private void sortProductsByPrice(){
		//à completer en tp (phase 2 facultative)
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
    	System.out.println("listeProduits="+listeProduits);
    	//csvUtil.writeStatFile(stat);
	}
    
    private void writeSortedProducts() {
    	//this.sortProductsByPrice();
    	//csvUtil.writeProductFile(this.listeProduits,"produits_tries_par_prix.csv");
    }
    
    private void writeStatsByCategories() {
		//csvUtil.writeStatFileFromCategorieMap(mapStatsByCategorie);
	}

}
