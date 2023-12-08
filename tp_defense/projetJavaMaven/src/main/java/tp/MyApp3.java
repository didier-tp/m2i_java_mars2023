package tp;

import java.util.Scanner;

public class MyApp3 {

	public static void main(String[] args) {
		//on va demander à l'utilisateur de saisir des nombres x et y
		//on va les additionner ensemble
		//et afficher le résultat
		Scanner reader = new Scanner(System.in);
		
		System.out.println("x:");
        //double x= reader.nextDouble(); //ok avec 6 ou 6,6 mais pas 6.6
		double x= myNextDouble(reader);
       // System.out.println("x=" + x);
        
        System.out.println("y:");
        //double y= reader.nextDouble();
        double y= myNextDouble(reader);
       // System.out.println("y=" + y);
        
        double resAdd= x+y;
        System.out.println("x+y=" + resAdd);
        
        reader.close();
	}
	
	public static double myNextDouble(Scanner scanner) {
		double v=0;
		String s=scanner.nextLine();
		s=s.replace(",",".");
		v=Double.parseDouble(s);
		return v;
	}

}
