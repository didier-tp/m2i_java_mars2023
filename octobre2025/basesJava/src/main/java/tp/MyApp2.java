package tp;

import java.util.ArrayList;
import java.util.List;

public class MyApp2 {
	
	public static void main(String[] args) {
		testListe();
		/*
		MyApp2 myApp2 = new MyApp2();
		myApp2.testPasStatic();
		*/
	}
	
	public static void testListe() {
		System.out.println("testListe");
		List<String> liste1 = new ArrayList<>();
		liste1.add("janvier"); liste1.add("fevrier");
		
		//...
	}
	
	/*
	public void testPasStatic() {
		//...
	}*/

}
