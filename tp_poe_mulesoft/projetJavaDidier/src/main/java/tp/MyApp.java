package tp;

import javax.swing.JOptionPane;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello world");   
        //essai1();
		//essai2();
		/*
		MyApp myApp = new MyApp();
		myApp.essaiCompte();
		*/
		//essaiCompte(); //static
		//essaiPersonne();
		essaiEmploye();
		//essaiString();
		//essaiTableau();
	}
	
	public static void essaiEmploye() {
		Employe e1 = new Employe();
		e1.setNom("Bon"); e1.setPrenom("jean"); e1.setAge(27);
		e1.setFonction("comptable"); e1.setSalaire(2000.0);
		e1.incremeterAge();
		e1.afficher();
		System.out.println("listeOccupations de e1 = " + e1.listeOccupations());
		
		Employe e2 = new Employe("Therieur","alain" , 34,"comptable",2000.0);
		e2.afficher();
		System.out.println("e2="+e2.toString());
		
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
			/*
			System.out.println("pour i=" + i + " tab1[i]=" + tab1[i] 
					+ " racine carree=" + Math.sqrt(tab1[i]));
			*/
			System.out.printf("pour i=%d , tab1[i]= %d racine carree= %f \n" , 
					                i ,tab1[i] ,  Math.sqrt(tab1[i]));
		}
		
		//A FAIRE (COMPLETER) EN TP:
		//trouver et afficher l'indice et la valeur de la plus grande valeur du tableau tab1
		int posMax=-1;
		int valMax=-99999999;
		int i=0;
		while(i<tab1.length) {
			if(tab1[i] >= valMax) {
				valMax=tab1[i]; 
				posMax=i;
			}
			i++;
		}
		System.out.println("plus grande valeur du tableau = " + valMax + " en position="  +posMax);
		
		//A FAIRE (COMPLETER) EN TP:
		//construire un tableau de "double" 12.0 , 14.0 , 10.0 , 8.0 , 6.0
		//calculer et afficher , la somme , la moyenne (et éventuellement l'écart type )
		//de ce tableau
        double[] tab2 = {  12.0 , 14.0 , 10.0 , 8.0 , 6.0 };
        double somme=0;
        for(int j=0;j<tab2.length;j++) {
        	somme=somme+tab2[j];
        }
        double moyenne= somme/tab2.length;
        System.out.println("tab2 , somme=" + somme + " moyenne= " + moyenne);
        double sommeCarreEcarts=0;
        for(int j=0;j<tab2.length;j++) {
        	double ecartAlaMoyenne = tab2[j] - moyenne ;
        	sommeCarreEcarts+=  ecartAlaMoyenne * ecartAlaMoyenne;
        }
        double ecartType= Math.sqrt(sommeCarreEcarts/tab2.length);
        System.out.println("tab2 , ecartType= " + ecartType);
		
		//plus autres essais libres ...
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
		
		//String s7="kayak";
		//String s7="papa";
		//String s7="tôt";
		//String s7="java";
		String s7="radar";
		//A FAIRE (COMPLETER) EN TP:
		//tester si s7 est un palindrome (se lit de la même façon dans les deux sens)
		boolean uneDifference=false;
		for(int i=0;i<s7.length();i++) {
			int indexInverse = s7.length() -1 -i;
			if(s7.charAt(i) != s7.charAt(indexInverse)) {
				uneDifference=true;
				break;
			}
		}
		if(uneDifference)
			System.out.println("s7 n'est pas un palindrome : " + s7);
		else
			System.out.println("s7 est un palindrome : " + s7);
	
		//tester si s7 vaut ou pas "java"
		/*
		if(s7.equals("java"))
			System.out.println("s7 vaut java ");
		else
			System.out.println("s7 est different de java");
		*/
		String message=(s7.equals("java"))?"s7 vaut java": "s7 est different de java";
		System.out.println(message);
		
		String s8="une tomate VERTE et une pomme VERTE sur une table";
		//A FAIRE (COMPLETER) EN TP:
		//constuire et afficher 3 variantes de s8
		//avec premier "VERTE" transformé en "ROUGE"
		//avec dernier "VERTE" transformé en "ROUGE"
		//avec tous les "VERTE" transformés en "ROUGE"
		int tailleDeVerte = "VERTE".length();
		int firstPos=s8.indexOf("VERTE");
		if(firstPos>0)
		    System.out.println( s8.substring(0, firstPos) + "ORANGE" + s8.substring(firstPos + tailleDeVerte ));
		int lastPos=s8.lastIndexOf("VERTE");
		if(firstPos>0)
		    System.out.println( s8.substring(0, lastPos) + "ORANGE" + s8.substring(lastPos + tailleDeVerte ));
		System.out.println( s8.replaceAll("VERTE", "ORANGE"));
		
		//plus autres essais libres ...
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
		
		System.out.println("esperanceDeVieFemme="+Personne.getEsperanceDeVieFemme());
		Personne.setEsperanceDeVieFemme(Personne.getEsperanceDeVieFemme()+1);
		System.out.println("nouvelle esperanceDeVieFemme="+Personne.getEsperanceDeVieFemme());
		System.out.println("AGE_MAJORITE en France="+Personne.AGE_MAJORITE);
		p1.setAge(16);
		System.out.println("a 16ans:" + (p1.estMajeur()?"majeur":"mineur" ));
		p1.setAge(26);
		System.out.println("a 26ans:" + (p1.estMajeur()?"majeur":"mineur" ));
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
		
		System.out.println("decouvert maxi autorisé=" + Compte.getDecouvertMaximumCommun());
		Compte.setDecouvertMaximumCommun(-600.0);
		System.out.println("decouvert maxi autorisé=" + Compte.getDecouvertMaximumCommun());
		//compte3.debiter(2000); //refusé
		compte3.debiter(200); //accepté
		System.out.println("compte3="+compte3);
		System.out.println("PI="+Math.PI);
		System.out.println("VIREMENT_MAXI_EN_LIGNE="+Compte.VIREMENT_MAXI_EN_LIGNE);
		//Compte.VIREMENT_MAXI_EN_LIGNE=5000; //impossible de changer la valeur d'une constante
		
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
