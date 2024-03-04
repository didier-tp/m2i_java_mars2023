package tp.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
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
	
	
}
