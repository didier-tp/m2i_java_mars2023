package tp;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestListe {
	
	@Test
	public void testListeCarre() {
		List<Integer> liste1 = new ArrayList<>();
		liste1.add(4);
		liste1.add(2);
		liste1.add(5);
		assertTrue(liste1.size()==3);
		
		List<Integer> listeCarres = new ArrayList<>();
		//on parcours la liste1 via for() au sens forEach
		//pour récupérer les valeurs une par une
		//on va stocker dans listeCarres les valeurs multipliées par elles memes
		for(Integer val : liste1) {
			listeCarres.add(val*val);
		}
		//plus parcours de listeCarres pour afficher les carrés un par un
		for(Integer valCarre : listeCarres) {
			System.out.println(valCarre);
		}
	}

}
