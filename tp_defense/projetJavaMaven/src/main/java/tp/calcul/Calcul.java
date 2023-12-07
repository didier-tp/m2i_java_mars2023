package tp.calcul;

public class Calcul {
	
	public int division(int a , int b) {
		//si b vaut 0 remonter une exception
		if(b==0) 
			throw new RuntimeException("division par zero interdite");
		return a/b;
	}
	
	public double racineCarree(double x) throws RuntimeException {
		//si x est négatif remonter une exception
		if(x<0) 
			throw new RuntimeException("racine carrée pas prévue pour x<0 en version double");
		return Math.sqrt(x);
	}

}
