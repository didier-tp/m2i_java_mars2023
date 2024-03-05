package tp;

//interface = chose entièrement abstraite = contrat = liste de fonctions imposées
public interface Transportable {
	public double getPoids(); //unité = kg
	public double getVolume(); //unité = litres
	public boolean estFragile();
	
	public static final String UNITE_POIDS = "kg";
	public static final String UNITE_VOLUME = "l"; //litre
}
