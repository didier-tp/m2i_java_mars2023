package tp;

import javax.swing.JOptionPane;

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
		  p1.nom="toto";  p1.age=44;  p1.poids=66.8;
		  p1.afficher();  //.afficher() appele en interne System.out.println(...)
		  Personne p2= new Personne();
		  p2.nom="titi";  p2.age=34;  p2.poids=77.8;
		  p2.afficher(); 
	  }
	
      public static void main(String[] args) {
		System.out.println("Hello world (main)");
		//testerTypes();
		testerPersonne();
	}
}
