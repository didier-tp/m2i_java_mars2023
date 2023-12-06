package tp;

import java.util.ArrayList;
import java.util.List;

public class Avion {
   private List<Transportable> elements = new ArrayList<>();
   
   public void addElement(Transportable e) {
	   //ajouter e dans this.elements
   }

	@Override
	public String toString() {
		String s = "Avion [nb_elements=" + elements.size() + "]";
		return s; //ou s + " ...";
	}
	
	public double chargeUtile() {
		//calculer et retourner le poids total
		//des elements de l'avion
		return 0.0;
	}
   
   
}
