package tp.data;

public class Compte {
	private Integer numero; // (1 ou 2 ou ...)
	private String label;
	private Double solde;// (50.0 ou ...)

	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + ", autorisation=" + autorisation
				+ "]";
	}
	
	

	public Compte(Integer numero, String label, Double solde, Autorisation autorisation) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
		this.autorisation = autorisation;
	}
	
	
	public Compte(Integer numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}
	
	

	public Compte() {
		super();
	}



	private Autorisation autorisation = new Autorisation();

	public Autorisation getAutorisation() {
		return autorisation;
	}

	public void setAutorisation(Autorisation autorisation) {
		this.autorisation = autorisation;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	
}
