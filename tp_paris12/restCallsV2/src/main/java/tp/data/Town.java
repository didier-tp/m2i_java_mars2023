package tp.data;

public class Town {

	private String codePostal;
	private String nomVille;
	private Double longitute;
	private Double latitude;
	private Integer population;
	
	

	public Town(String codePostal, String nomVille, Double longitute, Double latitude, Integer population) {
		super();
		this.codePostal = codePostal;
		this.nomVille = nomVille;
		this.longitute = longitute;
		this.latitude = latitude;
		this.population = population;
	}
	
	
	public Town() {
		
	}

    


	@Override
	public String toString() {
		return "Town [codePostal=" + codePostal + ", nomVille=" + nomVille + ", longitute=" + longitute + ", latitude="
				+ latitude + ", population=" + population + "]";
	}


	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public Double getLongitute() {
		return longitute;
	}
	public void setLongitute(Double longitute) {
		this.longitute = longitute;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	
	

}
