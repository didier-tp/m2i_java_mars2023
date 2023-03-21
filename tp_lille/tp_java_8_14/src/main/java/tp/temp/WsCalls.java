package tp.temp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WsCalls {
	
	private static ObjectMapper jacksonObjectMapper = new ObjectMapper();
	private static HttpClient httpClient = HttpClient.newHttpClient();
	
	public static CompletableFuture<HttpResponse<String>> sendAsyncGetRequest(String url){
		HttpRequest req =
				   HttpRequest.newBuilder(URI.create(url))
				              .header("User-Agent","Java")
				              .GET()
				              .build();
		return httpClient.sendAsync(req, BodyHandlers.ofString());
	}
	
	public static String extractTextOfHttpResponse(HttpResponse<String> response){
		return response.body();
	}
	
	public static CompletableFuture<HttpResponse<String>> composeWsCallFromZipOfVille(Ville ville) {
		String latLonFromZipWsUrl = """
				http://api.zippopotam.us/fr/%s""".formatted(ville.getZip());
		//System.out.println("latLonFromZipWsUrl="+latLonFromZipWsUrl);
		return sendAsyncGetRequest(latLonFromZipWsUrl); 
	}
	
	public static Ville addLatLonIntoVilleFromWsResultMap(Ville v,Map map){
		System.out.println("map="+map);
		List places = (List)map.get("places");
		v.setLon( Double.valueOf( ((Map) places.get(0)).get("longitude").toString() ) );
		v.setLat( Double.valueOf( ((Map) places.get(0)).get("latitude").toString() ) );
		return v;
	}
	
	public static Map jsonToMap(String jsonS) {
		//TypeReference<HashMap<String,Object>> typeRef  = new TypeReference<HashMap<String,Object>>() {};
		//HashMap<String,Object> map = jacksonObjectMapper.readValue(jsonS, typeRef);
		Map map = null;
		try {
			map = jacksonObjectMapper.readValue(jsonS, Map.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return map;		
	}
	
	public static Map extractJsonMapOfHttpResponse(HttpResponse<String> response){
		return jsonToMap(response.body());
	}


	public static void main(String[] args) {
		System.out.println("WsCalls ...");
		List<Ville> villesAvecMeteo = Arrays.asList(new Ville("Paris","75001"),
				new Ville("Bordeaux","33000"),new Ville("Nice","06000"),
				new Ville("Lyon","69001"),new Ville("Strasbourg","67000"));
		//Au sein de ce point de départ , on ne connait pas encore latitude , longitude ni temperature , ...
		
		for(Ville ville : villesAvecMeteo) {
			//System.out.println("ville="+ville);
			CompletableFuture<Ville> cfVille = new CompletableFuture<Ville>(); 
			cfVille.complete(ville);
			
			
			CompletableFuture<Map> cfResultMapOfZipWsCall = 
			  cfVille.thenCompose(WsCalls::composeWsCallFromZipOfVille)
				.thenApply(WsCalls::extractJsonMapOfHttpResponse);
			
			CompletableFuture<Ville> cfVilleWithLatLon=
			  cfVille.thenCombine(cfResultMapOfZipWsCall, WsCalls::addLatLonIntoVilleFromWsResultMap);
			
			//et ainsi de suite ...
			
			cfVilleWithLatLon.thenAccept(System.out::println)
			.join();
		}

	}

}
