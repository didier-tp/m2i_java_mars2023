package tp;

import javax.swing.JOptionPane;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello world");   
        //essai1();
		//essai2();
		//essaiCompte();
		//essaiPersonne();
		essaiString();
		essaiTableau();
	}
	
	public static void essaiTableau() {
		/*
		int[] tab1 = new int[5]; //tableau de 5 cases : [0] , ... , [4]
		tab1[0]=16;
		tab1[1]=64;
		tab1[2]=81;
		tab1[3]=100;
		tab1[4]=9;
		*/
		int[] tab1 = { 16, 64, 81 , 100, 9 };
		for(int i=0;i<tab1.length;i++) {
			System.out.println("pour i=" + i + " tab1[i]=" + tab1[i] 
					+ " racine carree=" + Math.sqrt(tab1[i]));
		}

	}
	
	public static void essaiString() {
		String s1 = "Java" , s2 = " est " , s3 ="orientié Objet";
		String s4 = s1+s2+s3;
		System.out.println("s4="+s4);
		String s5=s4.toUpperCase();
		System.out.println("s4="+s4);
		System.out.println("s5="+s5);
		System.out.println("taille="+s4.length());
		
		String s6="lundi;mardi;mercredi;jeudi";
		String[] partiesDeS6 = s6.split(";");
		System.out.println("partiesDeS6[0]=" + partiesDeS6[0]);
		System.out.println("partiesDeS6[2]=" + partiesDeS6[2]);
	}
	
	public static void essaiPersonne() {
		Personne p1 = new Personne();
		System.out.println("p1="+p1);
		//p1.prenom = "jean"; p1.nom="Bon";  //ANCIENNE VERSION avec PUBLIC
		p1.setPrenom("jean"); p1.setNom("Bon"); 
		p1.setAge(-30); //pas pris en compte (valeur invalide refusée)
		System.out.println("p1="+p1);
		p1.setAge(30); 
		System.out.println("p1="+p1);
		//p1.age=0;
		//p1.age=null; //l'age ne peut pas être à null si le type de .age est int
		//p1.age=-30;
		p1.incremeterAge();
		//System.out.println("p1="+p1.toString());
		System.out.println("p1="+p1);
		System.out.println("apres incrementerAge(), p1.age= " + p1.getAge() + " et p1.nomComplet()=" + p1.nomComplet() );
		
		Personne p2 = null;
		p2=new Personne();
		p2.setPrenom("Axelle"); p2.setNom("Aire"); p2.setAge(26);
		p2.incremeterAge();
		System.out.println("apres incrementerAge(), p2.age= " + p2.getAge() + " et p2.nomComplet()=" + p2.nomComplet() );
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
