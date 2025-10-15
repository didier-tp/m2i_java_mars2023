package tp;

import tp.pers.Employe;
import tp.pers.Personne;

public class MyApp {


	
	  public static void testerTypes() {
				  
		  String sX = "3";
		  String sY = "4";
		  //calculer la somme (après des conversions de "String" vers "int" ou "double")
		  String sXY  = sX+ sY ; //concaténation:
		  System.out.println("la concatenation  vaut " + sXY );
		  int x= Integer.parseInt(sX);
		  int y= Integer.parseInt(sY);
		  int somme = x+y;
		  System.out.println("la somme vaut " + somme);
		  String sZ="3.8";
		  double z = Double.parseDouble(sZ);
		  int iZ = (int) z;
		  System.out.println("(int) z=" + iZ);
		  System.out.println("Math.round(z)=" + Math.round(z));
		  
		  //String sAge = JOptionPane.showInputDialog(null, "votre age ?");
		  //System.out.println("sAge=" + sAge);
		  java.util.Scanner reader = new java.util.Scanner(System.in);
		  System.out.println( "votre age :");
		  String sAge = reader.next();
		  System.out.println("sAge=" + sAge);
	  }
	  
	  public static void testerPersonne() {
		 
			Personne p1=null;
			  p1= new Personne();
			  p1.setNom("toto"); p1.setAge(44); p1.setPoids(66.0);
			  //p1.nom="toto";  p1.age=44;  p1.poids=66.0; //seulement possible dans v1 où tout est public
			  p1.afficher();  //.afficher() appele en interne System.out.println(...)
			  System.out.println("p1=" + p1.toString() );
			  Personne p2= new Personne("titi",34,77.8);
			  //p2.nom="titi";  p2.age=34;  p2.poids=77.8; //seulement possible dans v1 où tout est public
			  p2.afficher(); 
			  System.out.println("p2=" + p2 ); //sous entendu  + p2.toString()
			  Personne p3= new Personne("titi",34,77.8);
			  if(p3.equals(p2))  //NB : il faut générer .equals() sur la classe Personne par assistant eclipse ou autre
				  System.out.println("p2 et p3 ont les mêmes valeurs internes");
			  else
			       System.out.println("p2 et p3 n'ont pas les mêmes valeurs internes");
			  try {
			     p2.setAge(-23); //message d'erreur (age invalide)
			  } catch (IllegalArgumentException e) {
					//e.printStackTrace();
				    System.err.println(e.getMessage());
			   }
			  System.out.println("p2=" + p2 ); //age inchangé
			  p2.setAge(23);
			  System.out.println("p2=" + p2 ); //nouvel age maintenant 23
		 
		  System.out.println("suite et fin ");
	  }
	  
	  public static void testerBagage() {
		  Bagage valise1 = new Bagage("valise1",12000.0,12.6);//12000g=12kg et 12.6 litres
		  valise1.setPoids(12500.0);
		  //System.out.println("valise1="+valise1.toString());
		  System.out.println("valise1="+valise1);
	  }
	  
	  public static void testTableaux() {
		  //construire et remplir un tableaux de 6 nombres reels
		  /*
		  double[] tableau  = new double[6];
		  tableau[0]=12.5;  tableau[1]=2;  tableau[2]=42.5;
		  tableau[3]=12.6;  tableau[4]=2.8;  tableau[5]=28.5;
		  */
		  double[] tableau  = { 12.5 , 2 , 42.5 , 12.6 , 2.8 , 28.5 };
		  for(int i=0;i<tableau.length;i++) {
			  System.out.println("tableau[" + i + "]=" + tableau[i]);
		  }
		  //calculer et afficher la moyenne
		  double somme = 0;
		  for(int i=0;i<tableau.length;i++) {
			  somme += tableau[i]; //somme = somme + tableau[i]
		  }
		  double moyenne = somme / tableau.length;
		  System.out.println("moyenne=" + moyenne);
		  //récupérer et afficher la plus grande valeur:
		  double plusGrand= tableau[0];
		  for(int i=1;i<tableau.length;i++) {
			  if(tableau[i]>plusGrand)
				  plusGrand=tableau[i];
		  }
		  System.out.println("plusGrand=" + plusGrand);
	  }
	  
      public static void testString() {
    	String s1 = "2023-01-17";
       //extraire la partie mois de différentes façons et afficher cette valeur
    	String sMois = s1.split("-")[1];
    	System.out.println("sMois="+sMois);
    	int posPremierTiret= s1.indexOf("-");
    	int posDernierTiret= s1.lastIndexOf("-");
    	String sMoisBis = s1.substring(posPremierTiret+1,posDernierTiret);
    	System.out.println("sMoisBis="+sMoisBis);
    	
       String chaine="YTREZA" ;
       //créer une nouvelle chaine inverse où tous les caractères sont dans l'ordre inverse 
       //afficher la chaine inverse
       StringBuilder buffer = new StringBuilder(chaine.length());
       for(int i=chaine.length()-1;i>=0;i--) {
    	   buffer.append(chaine.charAt(i));
       }
       String inverse=buffer.toString();
       System.out.println("inverse="+inverse);
	  }
	  
      public static void testStatic() {
    	  System.out.println("Personne.AGE_MAJORITE="+Personne.AGE_MAJORITE);
    	  Personne p1= new Personne("titi",14,77.8);
    	  Personne p2= new Personne("toto",24,67.8);
    	  Personne p=p2 ; //ou =p1;
    	  if(p.estMajeur())  
    		  System.out.println("p est majeur");
    	  else
    		  System.out.println("p est mineur");
    	  System.out.println("Espérance de vie actuelle des personnes="+Personne.getEsperanceVie());	
    	  //après pandémie de type "covid":
    	  Personne.setEsperanceVie(Personne.getEsperanceVie()-1.5);
    	  System.out.println("Nouvelle Espérance de vie des personnes="+Personne.getEsperanceVie());
    	  //après progrès de la médecine:
    	  Personne.setEsperanceVie(Personne.getEsperanceVie()+2.5);
    	  System.out.println("Nouvelle Espérance de vie des personnes="+Personne.getEsperanceVie());
    	  
    	  System.out.println("racine carrée de 81=" + Math.sqrt(81));
      }
      
      public static void testerEmploye() {
    	  Employe e1 = new Employe();
    	  e1.setNom("toto");
    	  e1.setAge(26);
    	  e1.setSalaire(2600.0);
    	  System.out.println("e1="+e1.toString() + " majeur:" + e1.estMajeur());
    	  
    	  Employe e2 = new Employe("jean Bon",44,77.6,2500.0);
    	  System.out.println("e2="+e2.toString());
    	  
    	  Personne p=null;
    	  
    	  p=new Personne("toto",45,67.9);
    	  //System.out.println("p="+p.toString());
    	  p.afficher(); //afficher() appel indirectement .toString() , polymorphisme indirect
    	  
    	  if(p instanceof Employe) {
    		  Double salaire = ((Employe) p).getSalaire();
    		  System.out.println("salaire de p="+salaire);
    	  }
    	  
    	  p=new Employe("toto2",55,77.9,2500.0);
    	  //System.out.println("p="+p.toString());
    	  p.afficher();
    	  
    	  //NB: if(... instanceof ....) et appel spécifique = techniquement possible mais très déconseillé!!!
    	  //if faut utiliser au maximum le polymorphisme
    	  if(p instanceof Employe) {
    		  Double salaire = ((Employe) p).getSalaire();
    		  System.out.println("salaire de p="+salaire);
    		  //p.afficherEmploye() // PAS BIEN
    	  }else {
    		  //p.afficherPersonne(); //PAS BIEN
    	  }
    	  
      }
      
      public static void testerPolymorphisme(){
    	  Animal a= null;
    	  a = new Chien();
    	  a.parler();
    	  a=new Chat();
    	  a.parler();
      }
      
      public static void testAvion(){
    	     //ObjectVolant obj = new ObjectVolant(); //new direct interdit car la classe ObjectVolant est "abstract"
    	  
    		 Avion a1 = new Avion();
    		 a1.initialiser();
    		 a1.afficher();
    	}
	
      public static void main(String[] args) {
		System.out.println("Hello world (main)");
		//testerTypes();
		testerPersonne();
		//testerBagage();
		//testTableaux();
		//testString();
		//testStatic();
		//testerEmploye();
		//testerPolymorphisme();
		//testAvion();
	}
}
