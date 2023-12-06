package tp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Bagage implements Transportable {
	
	private String label; //ou nom
	private double volume;
	private double poids;
	
	public Bagage(String label, double volume, double poids) {
		super();
		this.label = label;
		this.volume = volume;
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Bagage [label=" + label + ", volume=" + volume + ", poids=" + poids + "]";
	}
	

	@Override
	public double getVolume() {
		return volume;
	}

	@Override
	public double getPoids() {
		return poids;
	}


	
	

}
