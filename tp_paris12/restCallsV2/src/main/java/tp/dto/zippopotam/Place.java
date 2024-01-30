package tp.dto.zippopotam;

import com.fasterxml.jackson.annotation.JsonAlias;

public class  Place {
	
	@JsonAlias({"place_name" , "place name"})
	private String placeName;
	
	private String longitude;
	
	private String state;
	
	@JsonAlias({"state_abbreviation" , "state abbreviation"})
	private String stateAbbreviation;
	
	private String latitude;
	
	

	@Override
	public String toString() {
		return "Place [placeName=" + placeName + ", longitude=" + longitude + ", state=" + state
				+ ", stateAbbreviation=" + stateAbbreviation + ", latitude=" + latitude + "]";
	}

	public Place() {
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateAbbreviation() {
		return stateAbbreviation;
	}

	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}	
	
}//end of Place Class
