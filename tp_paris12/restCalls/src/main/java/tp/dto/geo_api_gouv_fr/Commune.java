package tp.dto.geo_api_gouv_fr;

import java.util.List;

public class Commune{
	  private String nom;
	  private String code;
	  private String codeDepartement;
	  private String codeRegion;
	  private List<String> codesPostaux;
	  private Integer population;
	  
	  
	  
	  
	public Commune() {
	}


	@Override
	public String toString() {
		return "Commune [nom=" + nom + ", code=" + code + ", codeDepartement=" + codeDepartement + ", codeRegion="
				+ codeRegion + ", codesPostaux=" + codesPostaux + ", population=" + population + "]";
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	public String getCodeRegion() {
		return codeRegion;
	}
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}
	public List<String> getCodesPostaux() {
		return codesPostaux;
	}
	public void setCodesPostaux(List<String> codesPostaux) {
		this.codesPostaux = codesPostaux;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	  
	  
}
