package tp;

import java.util.List;

import tp.data.Town;
import tp.dto.cat.CatFact;
import tp.dto.geo_api_gouv_fr.Commune;
import tp.dto.zippopotam.ZippopotamResponse;
import tp.util.MyCsvUtil;
import tp.util.MyHttp2Util;

public class MyApp {
	
	private static MyHttp2Util myHttp2Util = MyHttp2Util.INSTANCE;

	public static void main(String[] args) {
		System.out.println("ok");
		testSimpleWsCall();
		
		fetchMissingValuesWithWsCalls();
		
		
	}
	
	public static void testSimpleWsCall(){
		//phase 1 du TP 
        //appel facile catFact
		//...
		
		//l'URL du web service REST catFact est "https://catfact.ninja/fact"
		//Ce WS facile à appeler (sans api_key) retourne
		//une réponse au format JSON de type
		// { "fact" : "un fait sur les chats" , "length" :  21_ou_autre }
		String catFactUrl="https://catfact.ninja/fact";
		System.out.println("catFactUrl="+catFactUrl);
		//à faire en Tp , appeler le web service catFact
		//via MyHttp2Util.INSTANCE.fetchAsJsonString(...)
		//et afficher le résultat au format json
		String jsonStringResponse = MyHttp2Util.INSTANCE.fetchAsJsonString(catFactUrl);
		System.out.println("jsonStringResponse="+jsonStringResponse);
		
		//à faire en TP:
		//créer une classe java tp.dto.cat.CatFact 
		//comportant les attributs "fact" de type String
		//et length de type Integer
		
		//appeler une nouvelle fois le web service catFact
		//via MyHttp2Util.INSTANCE.fetch(..., CatFact.class)
		//et afficher le résultat au format java/.toString()
		CatFact catFactJavaResponse = MyHttp2Util.INSTANCE.fetch(catFactUrl,CatFact.class);
		System.out.println("catFactJavaResponse="+catFactJavaResponse);
	
	}
	
    public static void fetchMissingValuesWithWsCalls(){
    	//phase 2 du TP 
    	//appeler les web services nécessaires pour récupérer les informations
    	//manquantes de incomplete_towns.csv
    	//et générer towns.csv
    	
    	String inputFileName="incomplete_towns.csv"; //par défaut
    	String outputFileName="towns.csv"; //par défaut
    	
    	List<Town> listeTowns = MyCsvUtil.readTownsFile(inputFileName);
    	for(Town town : listeTowns) {
    		//code à peaufiner pour le rendre plus fiable (if != null , ...)
    		ZippopotamResponse zippopotamResponse = myHttp2Util.fetch("http://api.zippopotam.us/fr/"+town.getCodePostal(), ZippopotamResponse.class);
    		town.setLongitute(Double.parseDouble(zippopotamResponse.getPlaces().get(0).getLongitude()));
    		town.setLatitude(Double.parseDouble(zippopotamResponse.getPlaces().get(0).getLatitude()));
    		
    		List<Commune> communes = myHttp2Util.fetchList("https://geo.api.gouv.fr/communes?codePostal="+town.getCodePostal(), Commune.class);
    		Commune c = communes.get(0);
    		town.setNomVille(c.getNom());
    		town.setPopulation(c.getPopulation());
    	}
    	MyCsvUtil.writeTownsFile(listeTowns, outputFileName);
	}

}
