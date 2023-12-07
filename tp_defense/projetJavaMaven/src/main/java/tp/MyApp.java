package tp;

import java.util.Date;

import tp.geo.Cercle;
import tp.pers.Employe;
import tp.pers.Personne;

public class MyApp {

	public static void main(String[] args) {
		// commentaire qui va jusqu'a la fin de la ligne
		System.out.println("MyApp de projetJavaMaven");
		
		//java.util.Date aujourdhui = new java.util.Date();
		Date aujourdhui = new Date(); //avec import 
		System.out.println("aujourdhui="+aujourdhui);
		
        //calcul();
        //testObject();
		//testPersonne();
		//testCercle();
		//testString();
		//testTableau();
		testEmploye();
		//testPolymorsphisme();
		testAvion();
	}
	

	
	private static void testAvion() {
		Avion  a1 = new Avion();
		a1.addElement(new Bagage("valise en carton",40 , 20));//20kg
		a1.addElement(new Employe("Bon","jean",33,Employe.Fonction.PILOTE,4000.0));
		a1.addElement(new Employe("Aire","axelle",43,Employe.Fonction.HOTESSE,2000.0));
		a1.addElement(new Personne("Therieur","alain",28));
		a1.addElement(new Personne("Defrance","didier",54));
		
		System.out.println("avion a1=" + a1.toString());
		
		System.out.println("chargeUtile de a1=" + a1.chargeUtile());//4*75+20 = 320
		
	}



	private static void testPolymorsphisme() {
		Personne p=null; //la référence p peut référencer 
		                 //n'importe quel type de Personne
		                 //des instances de Personne ou de Employe ou ...
		
		//Rappel : si Employe hérite de Personne , 
		//Employe est vu comme un cas particulier de Personne
		
		Personne p1 = new Personne("Therieur","alain",44);
		Employe e1 = new Employe("Bon","jean",33,Employe.Fonction.PROGRAMMEUR,2000.0);
		
		p=p1;
		System.out.println("p="+p.toString());//appel automatique de Personne.toString()
		p=e1;
		System.out.println("p="+p.toString());//appel automatique de Employe.toString()
		
		//NB: polymorsphisme : memes appels --> code déclenché prenant forme différente
		
		//System.out.println("salaire de p="+ p.getSalaire()); //impossible car Personne n'a pas de salaire
		if(p instanceof Employe) {
			Employe pAsEmp = (Employe) p;
			System.out.println("salaire de pAsEmp="+ pAsEmp.getSalaire());
		}
		
		Transportable t=null; 
		//t = réference sur chose transportable quelconque (Personne ou Bagage ou ...)
		
		p1.setPoids(80.0);
		t=p1;//t référence une personne transportable
		System.out.println("poids de t="+t.getPoids());//polymorphisme Personne.getPoids()
		
		//t reférence plus bas un bagage transportable
		t=new Bagage("bagage xy" , 40 , 20); //40 litres , 20kg
		System.out.println("poids de t="+t.getPoids());//polymorphisme Bagage.getPoids()
	}
	



	private static void testEmploye() {
		Employe e1 = new Employe();
		e1.setFonction(Employe.Fonction.PROGRAMMEUR);
		System.out.println("fonction de e1= " 
		                + e1.getFonction());
		//constructeur de Employe(nom,prenom,age,fonction, salaire):
		Employe e2 = new Employe("Aire","axelle" ,33 , Employe.Fonction.COMPTABLE , 2000.0);
		System.out.println("e2="+e2); //System.out.println("e2="+e2.toString());
		e2.setSalaire(2100.0); //appel d'une méthode spécifique aux employes
		System.out.println("e2="+e2.toString());
		e2.setAge(34); //appel d'une méthode héritée de Personne
		System.out.println("e2="+e2.toString());
		if(e2.estMajeur())
			System.out.println("e2 est majeur");
	}



	public static void testTableau() {
		//construire un tableau de 16 cases de type double
		double[] tableau  = new double[16];
		//via une première boucle for , on va remplir ce tableau avec des valeurs aléatoires
		for(int i=0;i<tableau.length;i++) {
			double valAleatoire = Math.random() * 10; 
			tableau[i]=valAleatoire;
		}
	
		//boucle while pour afficher toutes les valeurs du tableau
		int compteur=0;
		while(compteur<tableau.length) {
			System.out.println(tableau[compteur]);
			compteur++;
		}
		//en exercice , trouver et afficher la plus grande des valeurs du tableau:
		double max= Double.MIN_VALUE;
		for(int i=0;i<tableau.length;i++) {
			if(tableau[i]>max)
				 max = tableau[i];
		}
		System.out.println("max="+max);
		
		//-----------------
		//Exemple2:
		String s1 = "jean;Bon;33";
		String[] partiesS = s1.split(";");
		//rappel: new Personne(nom,prenom,age)
		Personne p1 = new Personne(partiesS[1],partiesS[0],Integer.parseInt(partiesS[2]));
		System.out.println("p1="+p1.toString());
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void testString() {
		
		
		String sPhrase = "java est un langage orienté objet"; 
		//en exercice : construire et afficher une nouvelle version de cette chaine
		//au sein de laquelle la sous partie "langage" est convertie en majuscule si elle est trouvée
		//v1 (en s'appuyant sur .indexOf(sousPartieRecherchee) et .substring(posDebut,posFin+1) )
		//rappel , les positions des caractéres vont de 0 à taille-1
		String sousChaine = "langage";
		int tailleSousChaine = sousChaine.length();
		int posDebut = sPhrase.indexOf(sousChaine);
		if(posDebut>=0) {
			//phraseDebut + sousChaine en maj + phraseFin	
	        String nouvellePhrase=sPhrase.substring(0, posDebut)
	        		+ sPhrase.substring(posDebut, posDebut+tailleSousChaine).toUpperCase()		
	                + sPhrase.substring(posDebut+tailleSousChaine);
			System.out.println("nouvellePhrase="+nouvellePhrase);
		}
		//V2:
		String nouvellePhraseV2 = sPhrase.replaceAll(sousChaine, sousChaine.toUpperCase());
		System.out.println("nouvellePhraseV2="+nouvellePhraseV2);
		
		
		String s1 = "abcdef";
		//en exercice , construire et afficher s2 valant "fedcba" (avec caractères dans l'ordre inverse)
		String s2="";
		int taille = s1.length();
		StringBuilder buffer = new StringBuilder(taille);
		for(int i=taille-1 ; i>=0 ; i--)
			buffer.append(s1.charAt(i));
		s2=buffer.toString();
		System.out.println("s2="+s2);
		
		String sLangage="java";
		String sLang2 = "c++";
		String sLang3 = "JAVA".toLowerCase();
		//if(sLangage == sLang3) //PIEGE : OK en javascript mais pas toujours OK en java
		 if(sLangage.equals(sLang3))			
			System.out.println("meme langage");
		else
			System.out.println("langage different");
		
		String sLangMaj = sLangage.toUpperCase();
		System.out.println("sLangage="+sLangage);
		System.out.println("sLangMaj="+sLangMaj);
		sLangage="python"; //on remplace au bout de la référence sLangage tout l'instance "java" 
		                  //par l'objet "python"
		System.out.println("sLangage="+sLangage);
	}
	
	public static void testCercle() {
		Cercle c1=null,c2=null;
		c1=new Cercle(); c2=new Cercle(40,60,50,"red");
		c2.afficher();
		System.out.println("couleur de c2="+c2.getCouleur());
		//c1.rayon=50;
		c1.setRayon(50.0);
		System.out.println("couleur de c1="+c1.getCouleur());
		c1.setCouleur("blue");
		System.out.println("couleur de c1="+c1.getCouleur());
		System.out.println("rayon de c1=" + c1.getRayon());
		c1.setRayon(-60);
		System.out.println("rayon de c1=" + c1.getRayon());
		
		System.out.println("c1="+c1.toString() + " de perimetre=" + c1.perimetre()
		                                       + " de surface=" + c1.surface());
		System.out.println("c2="+c2.toString() + " de perimetre=" + c2.perimetre()
                                               + " de surface=" + c2.surface());
		//NB: .equals() doit être programmé sur la classe Cercle (via par exemple assistant eclipse)
		if(c1.equals(c2))
			System.out.println("c1 et c2 ont memes valeurs");
		else
			System.out.println("c1 et c2 ont des valeurs différentes");
	}
	
	public static void testPersonne() {
		Personne p1=null;
		p1 = new Personne("Bon" , "jean" , 40);
		try {
			p1.setAge(-6);//sera pas pris en compte
			System.out.println("p1="+p1.toString());
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}
		p1.setAge(16);
		System.out.println("p1="+p1.toString());
		p1.incrementerAge();//+1 , 17
		System.out.println("p1="+p1.toString() + " estMajeur=" + p1.estMajeur()); //false (pas majeur)
		
		Personne p2=null;
		p2 = new Personne();
 		//p2.age=37 interdit si age private
		p2.setAge(37);
		p2.incrementerAge();//+1 , 38
		System.out.println("p2="+p2.toString() + " estMajeur=" + p2.estMajeur());//true (majeur)
		
		/*
		int a=5;
		Integer objA =a ; // objA = new Integer(a); //automatic boxing depuis java5
		System.out.println("objA="+objA);
		*/
		System.out.println("age de majorité des Pesonnes=" + Personne.AGE_MAJORITE);
		System.out.println("espérance de vie actuelle des Personnes=" + Personne.getEsperanceVie());
		Personne.setEsperanceVie(80); //progrès de la médecine
		System.out.println("nouvelle espérance de vie des Personnes=" + Personne.getEsperanceVie());
	}
	
	public static void testObject() {
		Date objetDate = null; //la variable objetDate est une référence qui ne peut référencer que
		                        //des objets de type Date
		System.out.println("objetDate="+objetDate);//null
		objetDate = new Date(); //créer une instance/exemplaire de la classe Date
		System.out.println("objetDate="+objetDate.toString());//Mon Dec 04 15:25:22 CET 2023
	}
	
	public static void calcul() {
		int a=0;
	    int b=8;
		//double c=a/b;
	    double c= ((double) a) / ((double) b) ;
		boolean vraiOuFaux = true; 
		System.out.println("vraiOuFaux=" + vraiOuFaux);
		System.out.println("c=" + c);
		
		String s1="12";
		//String s1 = JOptionPane.showInputDialog("s1=", null);//résultat saisie clavier au format String
		String s2="3";
		String s3=s1+s2;
		int i1=Integer.parseInt(s1); // converti "12" en 12
		int i2=Integer.parseInt(s2); // converti "3" en 3
		int i3=i1+i2; // 3
		System.out.println("s3="+s3);
		System.out.println("i3="+i3);
		double x=3.3;
		int ix= (int) x; //conversion de type au dernier moment (cast)
		System.out.println("ix=" + ix);
	}
	

}
