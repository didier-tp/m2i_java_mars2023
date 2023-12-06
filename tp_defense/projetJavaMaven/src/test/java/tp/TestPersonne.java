package tp;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tp.pers.Personne;

public class TestPersonne {
	
	
	@Test
	public void testIncrementerAge() {
		Personne p1=new Personne("Bon" , "jean" , 42);
		p1.incrementerAge();
		System.out.println("nouvel age de p1=" + p1.getAge());
		assertTrue(p1.getAge()==43);
	}

}
