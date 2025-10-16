package tp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class Produit {
	
	private Integer numero; //id, clef primaire
	private String label;
	
	@CsvIgnore
	@JsonIgnore
	private String categorie;
	
	private Double prix;
	private Double poids;
	
	public Produit(Integer numero, String label, String categorie, Double prix, Double poids) {
		super();
		this.numero = numero;
		this.label = label;
		this.categorie = categorie;
		this.prix = prix;
		this.poids = poids;
	}
	
    
	
}
