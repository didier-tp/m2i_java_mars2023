package tp2;

public class MyApp2 {

	public static void main(String[] args) {
		testAnimal();

	}
	
	public static void testAnimal() {
		Animal a1 = new Animal("blanc",4.5);
		a1.afficher();
		a1.parler();
		
		Chat chat1 = new Chat();
		chat1.setCouleur("roux");
		chat1.setPoids(3.3);
		chat1.setNbHeureSommeil(14); 
		chat1.afficher();
		chat1.parler(); //appel indirectement chat1.miauler()
		
		Chat chat2 = new Chat("noir" , 4.4 , 15);//4.4 kg et 15h de sommeil
		chat2.afficher();
		chat2.parler();
	}
	
	

}
