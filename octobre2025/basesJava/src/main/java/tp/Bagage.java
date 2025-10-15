package tp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Bagage implements Transportable {
	 private String label;
	 private Double poids; //en grammes
	 private Double volume; //en litres
	 
	//+toString() , +constructeurs , +get/set 
	//à générer par assistants de l'IDE
	 

	 public Bagage(String label, Double poids, Double volume) {
		super();
		this.label = label;
		this.poids = poids;
		this.volume = volume;
	 }

	 @Override
	 public String getDesignation() {
		return this.label;
	 }
  
	 
}
