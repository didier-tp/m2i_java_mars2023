package tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale; 

public class Catalogue {
	
	private List<Produit> listeProduits;
	private Stats stats;
	
	public void lireFichierProduits() {
		this.listeProduits = new ArrayList<Produit>();
		try( BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("produits.csv")))
				) {
			br.readLine();//lire ligne d'entête 
			String ligne = br.readLine();//lire ligne de valeurs
			while(ligne!=null) {
				String[] t = ligne.split(";");
				Produit p = new Produit(Integer.parseInt(t[0]),
										t[1],
										Double.parseDouble(t[2]));
				listeProduits.add(p);
				ligne = br.readLine(); //on tente de lire la ligne suivante
			}
		} catch (IOException e) {
			e.printStackTrace();
		} //finally automatique qui déclenche .close() sur le br qu'il y a 
		// dans les parenthèses du try "with resource"
		System.out.println("listeProduits="+listeProduits);
	
	}
	
    public void calculerStats() {
    	  if(this.listeProduits==null) return;
		 //calculer this.stats à partir de this.listeProduits
    	  double sommePrix=0;
    	  double prixMini=Double.MAX_VALUE;
    	  double prixMaxi=Double.MIN_VALUE;
    	  int n = listeProduits.size();
    	  for(Produit p : this.listeProduits) {
    		  sommePrix += p.getPrix();
    		  if(p.getPrix()>=prixMaxi) prixMaxi = p.getPrix();
    		  if(p.getPrix()<=prixMini) prixMini = p.getPrix();
    	  }
    	  this.stats=new Stats(n,sommePrix/n,prixMini,prixMaxi);
	}
    
    public void ecrireFichierStats() {
    	    if(this.stats==null) return;
    	    try (
    			PrintStream ps = new PrintStream(new FileOutputStream("stats.csv"))
    			) {
    			    ps.println("nombreProduits;moyenneDesPrix;prixMini;prixMaxi");
    				ps.printf(Locale.US,"%d;%f;%f;%f" , this.stats.getNombreProduits() , 
    						                  this.stats.getMoyenneDesPrix(),
    						                  this.stats.getPrixMini() , 
    						                  this.stats.getPrixMaxi());
    		
    			System.out.println("le fichier stats.csv a ete regénéré (à voir apres refresh eclipse)");
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}//finally automatique qui déclenche .close() sur ps du try(ps=...)
	}


}
