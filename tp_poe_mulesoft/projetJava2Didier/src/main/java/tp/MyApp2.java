package tp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApp2 {

	public static void main(String[] args) {
		//essaiAnimaux();
		//essaiException();
		//essaiCollection();
		//essaiCollection2();
		essaiZoo();
		//essaiMap();
	}
	
	public static void essaiMap() {
		Map<String,String> mapCouleursAnglaisFrancais = new HashMap<>();
		mapCouleursAnglaisFrancais.put("red", "rouge");
		mapCouleursAnglaisFrancais.put("blue", "bleu");
		mapCouleursAnglaisFrancais.put("green", "vert");
		String couleurEnAnglais="blue";
		String couleurEnFrancais = mapCouleursAnglaisFrancais.get(couleurEnAnglais);
		System.out.println("couleurEnFrancais="+couleurEnFrancais);
	}
	
	public static void essaiZoo() {
		Zoo zoo = new Zoo("ZooXyz");
		Chien chien1 = new Chien("blanc",23.3 , "chien de compagnie");
		zoo.ajouterAnimal(chien1);
		zoo.ajouterAnimal(new Chat("noir" , 3.1 , 14 ));
		zoo.ajouterAnimal(new Chien("beige",20.3 , "gardien de troupeau"));
		zoo.ajouterAnimal(new Chat("marron" , 2.6 , 13 ));
		zoo.afficher();
		//...
	}
	
	public static void essaiCollection() {
		List<String> liste = new ArrayList<String>();
		liste.add("lundi"); 
		liste.add("mardi");
		liste.add("mercredi");
		liste.add("jeudi");
		System.out.println("taille=" + liste.size());
		
		for(int i=0;i<liste.size();i++) {
			System.out.println(liste.get(i) +  " en position i="+i);
		}
		
		liste.remove("jeudi");
		
		//for() au sens forEach():
		for(String val : liste) {
			System.out.println(val);
		}
	}
	
	public static void essaiCollection2() {
		List<Integer> liste = new ArrayList<>();
		liste.add(9);
		liste.add(1); 
		liste.add(16);
		liste.add(4);
		Collections.sort(liste);
		
		System.out.println("taille=" + liste.size());
		
		for(int i=0;i<liste.size();i++) {
			System.out.println(liste.get(i) +  " en position i="+i);
		}
		
		liste.remove(0);//avec ici le 0 interprété comme indice/position
		
		//for() au sens forEach():
		for(Integer val : liste) {
			System.out.println(val + " racineCarree=" + Math.sqrt(val));
		}
	}
	
	public static void essaiException() {
		try {
				//String sNum="50.5";
				String sNum="50a.5";
				System.out.println("sNum+1="+(sNum + 1)); //concatenation
				double num = conversion(sNum);
				System.out.println("num="+num);
				System.out.println("num+1="+(num+1));//addition
		} catch (NumberFormatException e) {
				e.printStackTrace();
		}
		System.out.println("suite de essaiException");
		
		
		try {
			System.out.println("6/2=" + division(6,2));
			System.out.println("6/0=" + division(6,0));//va provoquer une exception
			System.out.println("6/3=" + division(6,3));//CETTE LIGNE NE SERA JAMAIS EXECUTEE !!!
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("racine carre de 9=" + maRacineCarree(9));
			System.out.println("racine carre de -9=" + maRacineCarree(-9));//va provoquer une exception
		} catch (IllegalArgumentException e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}
		finally {
			System.out.println("racine carre de 64=" + maRacineCarree(64));
		}
		System.out.println("suite et fin de essaiException");
	}
	
	public static int division(int a , int b) throws ArithmeticException {
		return a/b;
	}
	
	public static double maRacineCarree(double x) throws IllegalArgumentException{
		if(x<0) 
			//throw new RuntimeException("racine carrée invalide si x négatif");
		    throw new IllegalArgumentException("racine carrée invalide si x négatif = " + x);
		return Math.sqrt(x);
	}
	
	
    public static double conversion(String s) throws NumberFormatException{
    	//NB: en interne .parseDouble souleve quelquefois NumberFormatException
		return Double.parseDouble(s);
	}
	
	public static void essaiAnimaux() {
		
		
		
		System.out.println("**** chat1 *****");
		Chat chat1 = new Chat();
		chat1.setCouleur("roux");
		chat1.setPoids(3.3);
		chat1.setNbHeureSommeil(14); 
		chat1.afficher();
		chat1.parler(); //appel indirectement chat1.miauler()
		
		System.out.println("**** chat2 *****");
		Chat chat2 = new Chat("noir" , 4.4 , 15);//4.4 kg et 15h de sommeil
		chat2.afficher();
		chat2.parler();
		
		System.out.println("**** chien1 *****");
		Chien chien1 = new Chien("beige" , 23.5 , "gradien_de_moutons");
		chien1.setPoids(chien1.getPoids()*0.9);//après un petit régime
		chien1.afficher();
		chien1.parler();
		chien1.aboyer();//possible su public
		
		//Animal animal = new Animal(); 
		//new Animal() maintenant impossible si la classe Animal est abstraite
		
		Animal a = null;// a peut référencer n'importe quelle sorte d'animal
		System.out.println("**** a=chat1 *****");
		a=chat1;//Chat hérite de Animal et est donc vu comme un cas particulier
		a.afficher(); 
		faireParlerUnAnimal(a);
		a.parler(); //POLYMORSPHIME et declenchement de "miaou miaou"
		// ou bien System.out.println(a.parler()); si a.parler() retourne une String
		System.out.println("**** a=chien1 *****");
		a=chien1;
		a.afficher();
		faireParlerUnAnimal(a);
		a.parler();  //POLYMORSPHIME et declenchement de "whouf wouf "
		//a.aboyer();//compilation impossible car .aboyer pas sur n'importquel animal
		/*
		//possible mais compliqué et déconseillé:
		if(a instanceof Chien) {
			Chien aVuCommeUnChien = (Chien) a;
			aVuCommeUnChien.aboyer();
		}
		*/
	}
	
	public static void faireParlerUnAnimal(Animal a) {
		
		//Question de philo : est ce que les animaux savent parler ?
		
		//code astucieux qui exploite le polymorphisme
		a.parler(); //qui en interne .miauler() pour les chats
		            // ou .aboyer() pour les chiens
		/*
		//code possible mais pas conseillé / pas astucieux:
		if(a instanceof Chat) {
			Chat aVuCommeUnChat = (Chat) a;
			aVuCommeUnChat.miauler();
		}
		else if(a instanceof Chien) {
			Chien aVuCommeUnChien = (Chien) a;
			aVuCommeUnChien.aboyer();
		}
		*/
	}

}
