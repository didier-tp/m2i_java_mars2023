package tp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tp.pers.ComparatorPersonneAgeDesc;
import tp.pers.ComparatorPersonneNom;
import tp.pers.Personne;

public class MyApp2 {
	
	public static void main(String[] args) {
		//testListe();
		testerCollectionPersonne();
		/*
		MyApp2 myApp2 = new MyApp2();
		myApp2.testPasStatic();
		*/
	}
	
	public static void testerCollectionPersonne(){
		//créer une liste de Personne , y ajouter quelques valeurs
		//List<Personne> listePers = new ArrayList<Personne>();
		List<Personne> listePers = new ArrayList<>(); //possible depuis java 1.7
		//var listePers = new ArrayList<Personne>(); //possible depuis java 10 (souvent 11 ou 17)
		
		listePers.add(new Personne("toto" , 30 , 77.6)); //new Personne(nom,age,poids)
		listePers.add(new Personne("dupond" , 36 , 78.6));
		listePers.add(new Personne("luc" , 25 , 76.6));
		
		//trier cette liste par noms croissants 
		//avec ComparatorPersonneNom puis afficher cette liste modifiée
		Collections.sort(listePers,new ComparatorPersonneNom());
		System.out.println("liste triée selon noms croissants:" + listePers);
		
		//trier une nouvelle fois cette liste par ages décroissants 
		//avec ComparatorPersonneAgeDesc puis afficher cette liste modifiée
		Collections.sort(listePers,new ComparatorPersonneAgeDesc());
		System.out.println("liste triée selon ages décroissants:" + listePers);
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
