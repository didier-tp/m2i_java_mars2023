package tp;

import java.util.ArrayList;
import java.util.List;

public class MyApp2 {
	
	public static void main(String[] args) {
		testListe();
		/*
		MyApp2 myApp2 = new MyApp2();
		myApp2.testPasStatic();
		*/
	}
	
	public static void testListe() {
		System.out.println("testListe");
		List<String> liste1 = new ArrayList<>();
		liste1.add("janvier"); liste1.add("fevrier"); liste1.add("mars");
		
		for(String s : liste1)
			System.out.println("s="+s);
		
		System.out.println("liste initiale=" + liste1.toString());
		
		List<String> listeMaj = new ArrayList<>();
		for(String s : liste1) {
			String sMaj = s.toUpperCase();
			listeMaj.add(sMaj);
		}
		liste1 = listeMaj;
			
		System.out.println("liste en majuscule=" + liste1.toString());
		System.out.println("taille de la liste=" + liste1.size());
		liste1.remove("JANVIER");
		System.out.println("nouvelle taille de la liste=" + liste1.size());
		System.out.println("liste apres suppression=" + liste1.toString());
		
		List<Integer> liste2 = new ArrayList<>();
		liste2.add(5); //liste2.add(new Integer(5));
		
	}
	
	/*
	public void testPasStatic() {
		//...
	}*/

}
