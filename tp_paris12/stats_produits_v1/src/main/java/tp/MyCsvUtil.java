package tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyCsvUtil {
	
	private String produitsFileName="produits.csv"; //par défaut
	private String statsFileName="stats.csv"; //par défaut
	//private String statsByCategorieFileName="stats_par_categories.csv"; //par défaut

	public List<Produit> readProductFile(){
		List<Produit> listeProduits = new ArrayList<>();
		
		try( FileInputStream fis = new FileInputStream(produitsFileName);
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis))
		    ){
			br.readLine();//lecture ligne d'entête
			String ligne = br.readLine(); //lecture première ligne de valeurs
			while(ligne!=null) {
				String p[] = ligne.split(";");
		        Produit produit = new Produit(
		        		Integer.parseInt(p[0]),
		        		p[1],
		        		p[2],
		        		Double.parseDouble(p[3]),
		        		Double.parseDouble(p[4]));
				listeProduits.add(produit);
				ligne = br.readLine(); //lecture prochaine ligne de valeurs
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//automatic finally in try(withResources){....}catch(...){...}
		//with automatic .close() on AutoClosable resource like FileInputStream or BufferedReader
			
		return listeProduits;
	}
	
	public void writeStatFile(Stat stat) {
		// a coder en tp
	}
	
	public void writeStatFileFromCategorieMap(Map<String,Stat> statMap) {
		//a coder en tp (phase 3 facultative)
	}

	public void writeProductFile(List<Produit> listeProduits,String outputFileName) {
		//a coder en tp (phase 2 facultative)
	}

}
