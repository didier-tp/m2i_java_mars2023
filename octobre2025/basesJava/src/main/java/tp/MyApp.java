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
	
      public static void main(String[] args) {
		System.out.println("Hello world (main)");
		testerTypes();
	}
}
