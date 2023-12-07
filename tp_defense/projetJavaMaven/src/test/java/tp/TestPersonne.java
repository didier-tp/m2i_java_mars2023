package tp;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import tp.pers.ComparateurDePersonne;
import tp.pers.Personne;

public class TestPersonne {
	
	@Test
	public void testTriDePersonne() {
		List<Personne> listePersonnes = new ArrayList<>();
		listePersonnes.add(new Personne("Zoro","zen",55));
		listePersonnes.add(new Personne("Bon","jean",45));
		listePersonnes.add(new Personne("Aire","axelle",56)) ; //...
		
		System.out.println("tri selon le nom des personnes:");
		ComparateurDePersonne comparateurDePersonne = new ComparateurDePersonne();//selon le nom
		Collections.sort(listePersonnes,comparateurDePersonne);
		for(Personne p : listePersonnes) {
		    System.out.println("\t" + p); //"\t" pour tabulation , "\n" pour saut de ligne
		}
		
		System.out.println("tri selon l'age des personnes:");
		Collections.sort(listePersonnes, new /* classe anonyme imbriquee qui implements */
				java.util.Comparator<Personne>() {
					public int compare(Personne o1, Personne o2) {
						return o1.getAge() - o2.getAge();
					}
		});
		for(Personne p : listePersonnes) {
		    System.out.println("\t" + p); 
		}
	}
	
	
	@Test
	public void testIncrementerAge() {
		Personne p1=new Personne("Bon" , "jean" , 42);
		p1.incrementerAge();
		System.out.println("nouvel age de p1=" + p1.getAge());
		assertTrue(p1.getAge()==43);
	}

}
