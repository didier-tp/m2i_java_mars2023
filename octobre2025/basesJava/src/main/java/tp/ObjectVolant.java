package tp;

public abstract class ObjectVolant {
	private String couleur ; //avec get/set
	public abstract int getPlafond(); //retourne l'altitude maximum possible pour Avion ou Helicoptère ou ...
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
}
