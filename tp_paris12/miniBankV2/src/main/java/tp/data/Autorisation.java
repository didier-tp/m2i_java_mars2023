package tp.data;

public class Autorisation {
	private Double decouvertAutorise = null;


	public Autorisation(Double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
	
	public Autorisation() {
		this(0.0); //découvertAutorisé par défaut = 0
	}

	public Double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(Double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	@Override
	public String toString() {
		return "Autorisation [decouvertAutorise=" + decouvertAutorise + "]";
	} 
	
	
}
