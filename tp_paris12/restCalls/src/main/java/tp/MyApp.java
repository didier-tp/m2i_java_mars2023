package tp;

public class MyApp {

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
		
		//à faire en Tp , appeler le web service catFact
		//via MyHttp2Util.INSTANCE.fetchAsJsonString(...)
		//et afficher le résultat au format json
		
		//à faire en TP:
		//créer une classe java tp.dto.cat.CatFact 
		//comportant les attributs "fact" de type String
		//et length de type Integer
		
		//appeler une nouvelle fois le web service catFact
		//via MyHttp2Util.INSTANCE.fetch(..., CatFact.class)
		//et afficher le résultat au format java/.toString()
		
		
	}
	
    public static void fetchMissingValuesWithWsCalls(){
    	//phase 2 du TP 
    	//appeler les web services nécessaires pour récupérer les informations
    	//manquantes de incomplete_towns.csv
    	//et générer towns.csv
	}

}
