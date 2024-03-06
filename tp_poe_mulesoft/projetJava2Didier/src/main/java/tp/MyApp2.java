package tp;

public class MyApp2 {

	public static void main(String[] args) {
		//essaiAnimaux();
		essaiException();
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
