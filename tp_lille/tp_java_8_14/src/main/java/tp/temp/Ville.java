package tp.temp;

public class Ville {
	private String name ; // ex:"Paris"
    private String zip ; //ex: "75001",
    private Double lat; //latitude
    private Double lon; //longitude
    private String weather_description; //ex: "clear sky" , "cloud" , ...
    private Double temperature ;
    
    

	public Ville(String name, String zip) {
		super();
		this.name = name;
		this.zip = zip;
	}


	public Ville() {
		
	}


	public Ville(String name, String zip, Double lat, Double lon, String weather_description, Double temperature) {
		super();
		this.name = name;
		this.zip = zip;
		this.lat = lat;
		this.lon = lon;
		this.weather_description = weather_description;
		this.temperature = temperature;
	}



	@Override
	public String toString() {
		return "Ville [name=" + name + ", zip=" + zip + ", lat=" + lat + ", lon=" + lon + ", weather_description="
				+ weather_description + ", temperature=" + temperature + "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getWeather_description() {
		return weather_description;
	}

	public void setWeather_description(String weather_description) {
		this.weather_description = weather_description;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	
	

}
