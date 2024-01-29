package tp;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyApp {
	
	private Stat stat;
	private List<Produit> listeProduits=null;
	//Map<String , List<Produit>> mapSubListProdByCategorie ;
	//Map<String , Stat> mapStatsByCategorie ;
	
	private MyCsvUtil csvUtil = new MyCsvUtil();

	public static void main(String[] args) {
		testMap();
	
		MyApp myApp = new MyApp();
		myApp.loadProducts();
		myApp.computeStats();
		//myApp.computeStatsByCategories();
		myApp.writeStats();
		//myApp.writeSortedProducts();
		//myApp.writeStatsByCategories();
	}
	
	private void loadProducts(){
		this.listeProduits = csvUtil.readProductFile();
	}
	
	
	public static void testMap(){
		Map<Integer,String> mapMois = new HashMap<>();
		mapMois.put(1, "janvier");
		//...
		mapMois.put(12, "decembre");
		String nomDuMoisNumero12 = mapMois.get(12);
		System.out.println("nomDuMoisNumero12="+nomDuMoisNumero12);//affiche décembre
		for(Integer key:mapMois.keySet()) {
			System.out.print("key="+key + " ");
			String value = mapMois.get(key);
			System.out.println("value=" + value);
		}
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

	
	private void sortProductsByPrice(){
		//à completer en tp (phase 2 facultative)
	}
	
    private void computeStats(){
		int nbProd=0;
		double sommePrix=0.0;
		double sommePoids=0.0;
		//à completer en tp
		this.stat = new Stat(nbProd,sommePrix/nbProd,sommePoids/nbProd);
	}
    
    private void writeStats(){
    	System.out.println("listeProduits="+listeProduits);
    	System.out.println("stats="+this.stat);
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
