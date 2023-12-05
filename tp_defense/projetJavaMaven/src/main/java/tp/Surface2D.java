package tp;

public class Surface2D {
	protected String couleur;
	
	public Surface2D(String couleur) {
		super();
		this.couleur = couleur;
	}
	
	public Surface2D() {
		this("black"); //couleur par defaut
	}
	

	@Override
	public String toString() {
		return "Surface2D [couleur=" + couleur + "]";
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
