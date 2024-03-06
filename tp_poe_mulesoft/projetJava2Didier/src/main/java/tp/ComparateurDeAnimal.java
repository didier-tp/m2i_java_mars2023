package tp;

import java.util.Comparator;

public class ComparateurDeAnimal implements Comparator<Animal>{

	@Override
	public int compare(Animal a1, Animal a2) {
		return (int)(a1.getPoids() - a2.getPoids());
		/*
		if(a1.getNom() != null)
			return a1.getNom().compareTo(a2.getNom());
			else return -1;
		*/
	}

	
}
