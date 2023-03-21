package tp.temp;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJacksonMap {
	
	private static ObjectMapper jacksonObjectMapper = new ObjectMapper();

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		String jsonS = """
			{"post code": "75001", "country": "France", "country abbreviation": "FR", "places": [{"place name": "Paris 01 Louvre", "longitude": "2.3417", "state": "\u00cele-de-France", "state abbreviation": "A8", "latitude": "48.8592"}]}
			""";
		System.out.println("jsonS="+jsonS);
		//TypeReference<HashMap<String,Object>> typeRef  = new TypeReference<HashMap<String,Object>>() {};
		Map map = jacksonObjectMapper.readValue(jsonS, Map.class);
		//HashMap<String,Object> map = jacksonObjectMapper.readValue(jsonS, typeRef); 
		System.out.println("map="+map);
		
		
	}

}
