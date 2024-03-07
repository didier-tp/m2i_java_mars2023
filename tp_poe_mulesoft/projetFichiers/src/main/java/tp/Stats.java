package tp;

public class Stats {
	private int nombreProduits;
	private double moyenneDesPrix;
	private double prixMini;
	private double prixMaxi;
	
	public Stats() {
		this(0,0.0,0.0,0.0);
	}

	public Stats(int nombreProduits, double moyenneDesPrix, double prixMini, double prixMaxi) {
		super();
		this.nombreProduits = nombreProduits;
		this.moyenneDesPrix = moyenneDesPrix;
		this.prixMini = prixMini;
		this.prixMaxi = prixMaxi;
	}

	@Override
	public String toString() {
		return "Stats [nombreProduits=" + nombreProduits + ", moyenneDesPrix=" + moyenneDesPrix + ", prixMini="
				+ prixMini + ", prixMaxi=" + prixMaxi + "]";
	}

	public int getNombreProduits() {
		return nombreProduits;
	}

	public void setNombreProduits(int nombreProduits) {
		this.nombreProduits = nombreProduits;
	}

	public double getMoyenneDesPrix() {
		return moyenneDesPrix;
	}

	public void setMoyenneDesPrix(double moyenneDesPrix) {
		this.moyenneDesPrix = moyenneDesPrix;
	}

	public double getPrixMini() {
		return prixMini;
	}

	public void setPrixMini(double prixMini) {
		this.prixMini = prixMini;
	}

	public double getPrixMaxi() {
		return prixMaxi;
	}

	public void setPrixMaxi(double prixMaxi) {
		this.prixMaxi = prixMaxi;
	}

}
