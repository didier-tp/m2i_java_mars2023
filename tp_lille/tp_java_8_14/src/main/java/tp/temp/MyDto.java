package tp.temp;

import java.util.List;

public class MyDto {
	
    public record PartialPlace(String longitude, String latitude) {
	}
    
   
	public record ZippopotamApiPartialResponse(List<PartialPlace> places) {
	}
	
	//------------
	
    public record WheaterInfos(String description) {
	}
    
    public record MainWheaterInfo(Double temp) {
	}
	
    public record WeatherApiPartialResponse(List<WheaterInfos> weather , MainWheaterInfo main) {
	}

}
