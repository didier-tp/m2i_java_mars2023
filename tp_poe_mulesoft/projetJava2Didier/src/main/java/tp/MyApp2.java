package tp;

public class MyApp2 {

	public static void main(String[] args) {
		essaiAnimaux();

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
		
		Animal a = null;// a peut référencer n'importe quelle sorte d'animal
		System.out.println("**** a=chat1 *****");
		a=chat1;//Chat hérite de Animal et est donc vu comme un cas particulier
		a.afficher(); 
		a.parler(); //POLYMORSPHIME et declenchement de "miaou miaou"
		System.out.println("**** a=chien1 *****");
		a=chien1;
		a.afficher(); 
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

}
