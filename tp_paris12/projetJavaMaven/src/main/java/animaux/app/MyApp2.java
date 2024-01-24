package animaux.app;

import java.util.Date;

import animaux.Animal;
import animaux.Chat;
import animaux.Chien;
import animaux.Transportable;

//import java.util.*;


public class MyApp2 {

	public static void main(String[] args) {
		testAnimal();
        // java.util.Date date = new java.util.Date(); //ok même sans import
        Date date = new Date();
        System.out.println("date="+date);
	}
	
	public static void testAnimal() {
		/*
		//ce n'est plus possible depuis que Animal est astract
		// new ClassAbstaite() est interdit
		Animal a1 = new Animal("blanc",4.5);
		a1.afficher();
		a1.parler();
		*/
		
		Chat chat1 = new Chat();
		chat1.setCouleur("roux");
		chat1.setPoids(3.3);
		chat1.setNbHeureSommeil(14); 
		chat1.afficher();
		chat1.parler(); //appel indirectement chat1.miauler()
		
		Chat chat2 = new Chat("noir" , 4.4 , 15);//4.4 kg et 15h de sommeil
		chat2.afficher();
		chat2.parler();
		
		Chien chien1 = new Chien("beige" , 23.5 , "gradien_de_moutons");
		chien1.setPoids(chien1.getPoids()*0.9);//après un petit régime
		chien1.afficher();
		chien1.parler();
		chien1.aboyer();//possible su public
		
		Animal a = null;// a peut référencer n'importe quelle sorte d'animal
		a=chat1;//Chat hérite de Animal et est donc vu comme un cas particulier
		a.afficher(); 
		a.parler(); //POLYMORSPHIME et declechement de "miaou miaou"
		a=chien1;
		a.afficher(); 
		a.parler();  //POLYMORSPHIME et declechement de "whouf wouf "
		//a.aboyer();//compilation impossible car .aboyer pas sur n'importquel animal
		/*
		//possible mais compliqué et déconseillé:
		if(a instanceof Chien) {
			Chien aVuCommeUnChien = (Chien) a;
			aVuCommeUnChien.aboyer();
		}
		*/
		
		Transportable choseTransportable = null;
		choseTransportable=chat1;
		//choseTransportable=personne1; //serait possible si class Personne implements Transportable
		System.out.println("poid de la chose transportable="
				+ choseTransportable.getPoids() + " " + choseTransportable.UNITE_POIDS);
		System.out.println("volume de la chose transportable="
				+ choseTransportable.getVolume() + " " + choseTransportable.UNITE_VOLUME);
	}
	
	

}
