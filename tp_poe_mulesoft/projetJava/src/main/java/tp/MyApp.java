package tp;


public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello world");   
        //essai1();
		//essai2();
		//essaiCompte();
		essaiPersonne();
	}
	
	public static void essaiPersonne() {
		Personne p1 = new Personne();
		p1.prenom = "Jean"; p1.nom="Bon"; p1.age=30;
		p1.incremenerAge();
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
		compte1.numero="c1";
		compte1.solde=500.0; 
		compte1.crediter(50); //on ajoute 50 euros sur le compte1
		System.out.println("apres crediter , compte1.solde="+compte1.solde); //550.0
		
		Compte compte2 = null; //on déclare ici une variable commpte2 pourra référencer un futur objet de type Compte
		compte2 = new Compte();//la variable compte2 référence l'objet créé par new ...
		compte2.numero="c2";
		compte2.solde=300.0;
		compte2.debiter(50); //on retirer 50 euros sur le compte2
		System.out.println("apres debiter , compte2.solde="+compte2.solde); //250.0
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
