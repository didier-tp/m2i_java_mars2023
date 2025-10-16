package tp;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyCsvApp {
	
	public static void main(String[] args) {
		  MyCsvUtil myCsvUtil = new MyCsvUtil();
		  List<Produit> listeProduits = myCsvUtil.readFile("produits.csv");
		  System.out.println("listeProduits"+listeProduits);
		  
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
		  
		  //MyGenericCsvUtil.decrire("tp.Produit");
		  
		  //Suite faculative du Tp : générer un fichier avec produits triés par prix:
		  
		  List<Produit> listeProduitsTries = 
				  listeProduits.stream()
				               .sorted((p1,p2)-> Double.compare(p1.getPrix(),p2.getPrix()) )
				               .toList();
		  MyGenericCsvUtil.writeValuesAsCsvFile(listeProduitsTries, "produitsTries.csv");
		  
		  try {
			//generer du  json via  l'api jackson-databind:
			  ObjectMapper jacksonObjectMapper = new ObjectMapper();
			  String listeProdAsJsonString = jacksonObjectMapper.writeValueAsString(listeProduitsTries);
			  System.out.println("via jackson, listeProdAsJsonString="+listeProdAsJsonString);
			  //plus qu'à placer ça dans un ficher texte ou l'envoyer en tant que réponse à une requete HTTP:
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
