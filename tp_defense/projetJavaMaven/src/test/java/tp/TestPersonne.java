package tp;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import tp.pers.ComparateurDePersonne;
import tp.pers.Personne;

public class TestPersonne {
	
	@Test
	public void testPrintf() {
		Personne p1 = new Personne("Bon","jean",15);
		System.out.printf("%s %s \n", p1.getPrenom() , p1.getNom());
		System.out.printf("%s %s a %d ans \n", p1.getPrenom() , p1.getNom(),p1.getAge());
	}
	
	@Test
	public void testTriDePersonne() {
		List<Personne> listePersonnes = new ArrayList<>();
		listePersonnes.add(new Personne("Zoro","zen",15));
		listePersonnes.add(new Personne("Bon","jean",45));
		listePersonnes.add(new Personne("Aire","axelle",56)) ; //...
		
		System.out.println("tri selon le nom des personnes:");
		ComparateurDePersonne comparateurDePersonne = new ComparateurDePersonne();//selon le nom
		Collections.sort(listePersonnes,comparateurDePersonne);
		for(Personne p : listePersonnes) {
		    System.out.println("\t" + p); //"\t" pour tabulation , "\n" pour saut de ligne
		}
		
		System.out.println("tri selon l'age des personnes:");
//		Collections.sort(listePersonnes, new /* classe anonyme imbriquee qui implements */
//				java.util.Comparator<Personne>() {
//					public int compare(Personne o1, Personne o2) {
//						return Integer.compare(o1.getAge() , o2.getAge());
//					}
//		});
		
		//tri via une lambda expression (possible java 8):
		Collections.sort(listePersonnes,
				(p1,p2)->  Integer.compare(p1.getAge(), p2.getAge())  );
		
		for(Personne p : listePersonnes) {
		    System.out.println("\t" + p); 
		}
		
		System.out.println("listePersonnesFiltreesTrieesEtTransformees via stream et lambda:");
		List<Personne> listePersonnesFiltreesTrieesEtTransformees =
				listePersonnes.stream()
				 .filter( (p)->p.getAge()>=18 )
				 .sorted( (p1,p2)->Integer.compare(p2.getAge(), p1.getAge()))
				 .map( (p) -> new Personne(p.getNom().toUpperCase(),p.getPrenom(),p.getAge()) )
				 .collect(Collectors.toList());
		for(Personne p : listePersonnesFiltreesTrieesEtTransformees) {
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
