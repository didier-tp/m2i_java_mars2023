package tp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Bagage {
	 private String label;
	 private Integer poids; //en grammes
	 private Double volume; //en litres
	 
	//+toString() , +constructeurs , +get/set 
	//à générer par assistants de l'IDE
	 

	 public Bagage(String label, Integer poids, Double volume) {
		super();
		this.label = label;
		this.poids = poids;
		this.volume = volume;
	 }
  
	 
}
