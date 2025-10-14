package tp;

public class Bagage {
	 private String label;
	 private Integer poids; //en grammes
	 private Double volume; //en litres
	 
	//+toString() , +constructeurs , +get/set 
	//à générer par assistants de l'IDE
	 
	 public Bagage() {
		super();
	}



	 public Bagage(String label, Integer poids, Double volume) {
		super();
		this.label = label;
		this.poids = poids;
		this.volume = volume;
	 }



	 @Override
	 public String toString() {
		return "Bagage [label=" + label + ", poids=" + poids + ", volume=" + volume + "]";
	 }



	 public String getLabel() {
		 return label;
	 }



	 public void setLabel(String label) {
		 this.label = label;
	 }



	 public Integer getPoids() {
		 return poids;
	 }



	 public void setPoids(Integer poids) {
		 this.poids = poids;
	 }



	 public Double getVolume() {
		 return volume;
	 }



	 public void setVolume(Double volume) {
		 this.volume = volume;
	 }
	 
	 
	 
	 
	 
}
