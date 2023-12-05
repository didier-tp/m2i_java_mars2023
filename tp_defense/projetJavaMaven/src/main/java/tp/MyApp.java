package tp;



import java.util.Date;

public class MyApp {

	public static void main(String[] args) {
		// commentaire qui va jusqu'a la fin de la ligne
		System.out.println("MyApp de projetJavaMaven");
        //calcul();
        //testObject();
		testPersonne();
		//testCercle();
	}
	
	public static void testCercle() {
		Cercle c1=null,c2=null;
		c1=new Cercle(); c2=new Cercle(40,60,50);
		//c1.rayon=50;
		c1.setRayon(50.0);
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
		p1.setAge(-6);//sera pas pris en compte
		System.out.println("p1="+p1.toString());
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
