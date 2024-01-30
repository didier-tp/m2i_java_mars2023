package tp.data;

public class Compte {
	//numero (1 ou 2 ou ...)
	//label
	//solde (50.0 ou ...)
	private Autorisation autorisation = new Autorisation();

	public Autorisation getAutorisation() {
		return autorisation;
	}

	public void setAutorisation(Autorisation autorisation) {
		this.autorisation = autorisation;
	}
	
	
}
