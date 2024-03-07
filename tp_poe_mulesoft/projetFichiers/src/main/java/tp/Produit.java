package tp;

public class Produit {
   //à coder avec numero,label,prix
	private int numero;
	private String label;
	private double prix;
	
	public Produit(int numero, String label, double prix) {
		super();
		this.numero = numero;
		this.label = label;
		this.prix = prix;
	}

	public Produit() {
		this(0,"?",0.0);
	}

	@Override
	public String toString() {
		return "Produit [numero=" + numero + ", label=" + label + ", prix=" + prix + "]";
	}
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
