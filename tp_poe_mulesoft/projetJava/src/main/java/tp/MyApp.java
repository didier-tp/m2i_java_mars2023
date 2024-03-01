package tp;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("Hello world");   
        essai1();
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
