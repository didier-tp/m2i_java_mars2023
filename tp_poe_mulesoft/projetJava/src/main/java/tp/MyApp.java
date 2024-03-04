package tp;

import javax.swing.JOptionPane;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello world");   
        //essai1();
		//essai2();
		essaiCompte();
		//essaiPersonne();
	}
	
	public static void essaiPersonne() {
		Personne p1 = new Personne();
		System.out.println("p1="+p1);
		p1.prenom = "jean"; p1.nom="Bon"; 
		p1.age=30; 
		System.out.println("p1="+p1);
		//p1.age=0;
		//p1.age=null; //l'age ne peut pas être à null si le type de .age est int
		//p1.age=-30;
		p1.incremenerAge();
		//System.out.println("p1="+p1.toString());
		System.out.println("p1="+p1);
		System.out.println("apres incrementerAge(), p1.age= " + p1.age + " et p1.nomComplet()=" + p1.nomComplet() );
		
		Personne p2 = null;
		p2=new Personne();
		p2.prenom = "Axelle"; p2.nom="Aire"; p2.age=26;
		p2.incremenerAge();
		System.out.println("apres incrementerAge(), p2.age= " + p2.age + " et p2.nomComplet()=" + p2.nomComplet() );
	}
	
	public static void essaiCompte() {
		//compte1 et compte2 sont des objets/exemplaires/instances de la  classe Compte
		//compte1 et compte2 sont des variables de type Compte (toute classe Java est vu comme un type de données "orienté objet")
		//le mot clef new permet de créer un exemplaire/instance de la classe Compte.
		Compte compte1 = new Compte(); 
		compte1.setNumero("c1");
		//compte1.setSolde(-5000000000.0); 
		compte1.setSolde(500);
		compte1.crediter(50); //on ajoute 50 euros sur le compte1
		System.out.println("apres crediter , compte1.solde="+compte1.getSolde()); //550.0
		//System.out.println("compte1="+compte1.toString());
		System.out.println("compte1="+compte1); //.toString() appelé automatiquement
		//JOptionPane.showMessageDialog(null, "compte1="+compte1);
		
		Compte compte2 = null; //on déclare ici une variable commpte2 pourra référencer un futur objet de type Compte
		compte2 = new Compte();//la variable compte2 référence l'objet créé par new ...
		compte2.setNumero("c2");
		compte2.setSolde(300.0);
		compte2.debiter(50); //on retirer 50 euros sur le compte2
		System.out.println("apres debiter , compte2.solde="+compte2.getSolde()); //250.0
		
		Compte compte2Bis = new Compte("c2",250.0);
		if(compte2.equals(compte2Bis)) //avec besoin de coder Compte.equals() par assistant eclipse
			System.out.println("compte 2 et compte2Bis ont mêmes valeurs en interne");
		else
			System.out.println("compte 2 et compte2Bis ont des valeurs différentes");
			
		
		Compte compte3=new Compte("c3",303.0);
		System.out.println("compte3="+compte3);
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
		double c=0;
		double res=a/b; 
		System.out.println("c=" + c);  
		System.out.println("res=" + res);  
		if(res >=13)
			System.out.println("res est superieur ou egal à 13");
		else 
			System.out.println("res est plus petit que 13");
		boolean vraiOuFaux = (res >=13);
		System.out.println("vraiOuFaux=" + vraiOuFaux);  
	}

}
