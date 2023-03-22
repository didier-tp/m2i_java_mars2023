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
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WsCalls {
	
	private static ObjectMapper jacksonObjectMapper = new ObjectMapper();
	private static HttpClient httpClient = HttpClient.newHttpClient();
	
	static {
		jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
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
	
	public static CompletableFuture<HttpResponse<String>> composeWsCallFromLatLonOfVille(Ville ville) {
		String apiKey = "27a68278aebee75af9d4fc23d7a68f75";
		String weatherWsUrl = """
				https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s"""
				.formatted(String.valueOf(ville.getLat()),
						   String.valueOf(ville.getLon()),
						   apiKey);
		//System.out.println("weatherWsUrl="+weatherWsUrl);
		return sendAsyncGetRequest(weatherWsUrl); 
	}
	
	
	
	
	/*
	//V1 (via map)
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
	
	public static Ville addLatLonIntoVilleFromWsResultMap(Ville v,Map map){
		System.out.println("map="+map);
		List places = (List)map.get("places");
		v.setLon( Double.valueOf( ((Map) places.get(0)).get("longitude").toString() ) );
		v.setLat( Double.valueOf( ((Map) places.get(0)).get("latitude").toString() ) );
		return v;
	}
	
	*/
	
	public static MyDto.ZippopotamApiPartialResponse jsonToZippopotamRecord(String jsonS) {
		MyDto.ZippopotamApiPartialResponse resp=null;
		try {
			resp = jacksonObjectMapper.readValue(jsonS, MyDto.ZippopotamApiPartialResponse.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//System.out.println("zippo_resp="+resp);
		return resp;		
	}
	
	
	
	public static MyDto.ZippopotamApiPartialResponse extractZippopotamRecordOfHttpResponse(HttpResponse<String> response){
		return jsonToZippopotamRecord(response.body());
	}
	
	public static Ville addLatLonIntoVilleFromWsResultRecord(Ville v,MyDto.ZippopotamApiPartialResponse zippoResp){
		//System.out.println("zippoResp="+zippoResp);
		v.setLon( Double.valueOf( zippoResp.places().get(0).longitude() ) );
		v.setLat( Double.valueOf( zippoResp.places().get(0).latitude() ) );
		return v;
	}
	
	public static MyDto.WeatherApiPartialResponse jsonToWeatherRecord(String jsonS) {
		MyDto.WeatherApiPartialResponse resp=null;
		try {
			resp = jacksonObjectMapper.readValue(jsonS, MyDto.WeatherApiPartialResponse.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//System.out.println("weather_resp="+resp);
		return resp;		
	}
	
	
	
	public static MyDto.WeatherApiPartialResponse extractWeatherRecordOfHttpResponse(HttpResponse<String> response){
		return jsonToWeatherRecord(response.body());
	}
	
	public static Ville addWeatherIntoVilleFromWsResultRecord(Ville v,MyDto.WeatherApiPartialResponse weatherResp){
		//System.out.println("weatherResp="+weatherResp);
		v.setWeather_description( weatherResp.weather().get(0).description() );
		v.setTemperature( weatherResp.main().temp() -273.15  );
		return v;
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
			
			/*
			//V1 via Map
			CompletableFuture<Map> cfResultMapOfZipWsCall = 
			  cfVille.thenCompose(WsCalls::composeWsCallFromZipOfVille)
				.thenApply(WsCalls::extractJsonMapOfHttpResponse);
			
			CompletableFuture<Ville> cfVilleWithLatLon=
			  cfVille.thenCombine(cfResultMapOfZipWsCall, WsCalls::addLatLonIntoVilleFromWsResultMap);
			*/
			//V2 via partial Dto/record:
			CompletableFuture<MyDto.ZippopotamApiPartialResponse> cfResultRecordOfZipWsCall = 
					  cfVille.thenComposeAsync(WsCalls::composeWsCallFromZipOfVille)
						.thenApply(WsCalls::extractZippopotamRecordOfHttpResponse);
					
					CompletableFuture<Ville> cfVilleWithLatLon=
					  cfVille.thenCombine(cfResultRecordOfZipWsCall, WsCalls::addLatLonIntoVilleFromWsResultRecord);
			
			//et ainsi de suite ...
			
			CompletableFuture<MyDto.WeatherApiPartialResponse> cfResultRecordOfWeatherWsCall = 				
			  cfVilleWithLatLon.thenComposeAsync(WsCalls::composeWsCallFromLatLonOfVille)
			.thenApply(WsCalls::extractWeatherRecordOfHttpResponse);
			
			CompletableFuture<Ville> cfVilleWithWeather=
			  cfVilleWithLatLon.thenCombine(cfResultRecordOfWeatherWsCall, WsCalls::addWeatherIntoVilleFromWsResultRecord);
			
			cfVilleWithWeather.thenAccept(System.out::println)
			.join();
		}

	}

}
