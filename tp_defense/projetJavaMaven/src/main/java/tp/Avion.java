package tp;

import java.util.ArrayList;
import java.util.List;

public class Avion {
   private List<Transportable> elements = new ArrayList<>();
   
   public void addElement(Transportable e) {
	   //ajouter e dans this.elements
	   this.elements.add(e);
   }

	@Override
	public String toString() {
		String s = "Avion [nb_elements=" + elements.size() + "]";
		return s; //ou s + " ...";
	}
	
	public double chargeUtile() {
		//calculer et retourner le poids total
		//des elements de l'avion
		double poidsTotal=0.0;
		for(Transportable e : this.elements) {
			//poidsTotal = poidsTotal + e.getPoids();
			poidsTotal += e.getPoids();  //polymorphisme sur .getPoids()
		}
		return poidsTotal;
	}
   
   
}
