package tp.dto.zippopotam;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
/* exemple  http://api.zippopotam.us/fr/75001
 renvoyant
 {"post code": "75001", "country": "France", 
"country abbreviation": "FR", 
"places": [{"place name": "Paris 01 Louvre", "longitude": "2.3417",
 "state": "Ile-de-France", "state abbreviation": "A8", 
 "latitude": "48.8592"}]}
 */

public class ZippopotamResponse {
	
	@JsonAlias({"post_code" , "post code"})
	private String postCode;
	
	private String country;
	
	@JsonAlias({"country_abbreviation" , "country abbreviation"}) 
	private String countryAbbreviation;
	
	private List<Place> places;
	
	
	public ZippopotamResponse() {
	}


	@Override
	public String toString() {
		return "ZippopotamResponse [postCode=" + postCode + ", country=" + country + ", countryAbbreviation="
				+ countryAbbreviation + ", places=" + places + "]";
	}

	
	
	public String getPostCode() {
		return postCode;
	}


	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCountryAbbreviation() {
		return countryAbbreviation;
	}


	public void setCountryAbbreviation(String countryAbbreviation) {
		this.countryAbbreviation = countryAbbreviation;
	}


	public List<Place> getPlaces() {
		return places;
	}


	public void setPlaces(List<Place> places) {
		this.places = places;
	}

}
