package tp;


public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello world");   
        //essai1();
		essai2();
	}
	
	public static void essai2() {
		//NB: .showInputDialog() affiche une boîte de dialogue qui récupére une valeur sous forme de String
		//NB2 : Attention, la fintion JOptionPane.showInputDialog() n'est pas utilisable sur un ordinateur
		//où il n'y a pas d'écran graphique.
		//String sAge = javax.swing.JOptionPane.showInputDialog(null, "votre age");
		
		System.out.println("votre age:");
		java.util.Scanner scanner = new java.util.Scanner(System.in); //pour une saisie au clavier en mode texte 
		//(sans écran graphique , dans une console ou terminal texte)
		String sAge = scanner.nextLine();
		
		System.out.println("sAge="+sAge);   
		//nouvelAge=nouvelAge+1
		/*
		sAge=sAge+1; //concatenation plutot que addition
		System.out.println("sAge="+sAge);
		*/
		int age = Integer.parseInt(sAge);
		age=age+1;//addition
		System.out.println("age incrémenté="+age); //le + entre 2 String déclenche une concatenation (chaines bout à bout )
	}
	
	public static void essai1() {
		/*
		int a=36; 
		int b=10;
		int res=a/b; 
		*/
	
		double a=36.0;
		double b=10.0;
		double res=a/b; 
		
		System.out.println("res=" + res);  
		if(res >=13)
			System.out.println("res est superieur ou egal à 13");
		else 
			System.out.println("res est plus petit que 13");
		boolean vraiOuFaux = (res >=13);
		System.out.println("vraiOuFaux=" + vraiOuFaux);  
	}

}
