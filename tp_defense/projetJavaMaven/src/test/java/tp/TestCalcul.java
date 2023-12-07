package tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.calcul.Calcul;

public class TestCalcul {
	
	private Logger logger = LoggerFactory.getLogger(TestCalcul.class);
	
	@Test
	public void testDivision() {
		Calcul objCalcul = new Calcul();
		int res1 = objCalcul.division(6, 3);
		//System.out.println("res1="+res1);
		logger.debug("res1="+res1);
		//Assertions.assertTrue(res1==2); //en JUnit5
		//Assert.assertTrue(res1==2); //en JUnit4
		assertTrue(res1==2);
	}
	
	@Test
	public void testDivisionAvecException() {
		Calcul objCalcul = new Calcul();
		try {
			int res1 = objCalcul.division(6, 0);
			System.out.println("res1="+res1);
			fail("si aucune exception ne remonte , c'est pas normal");
		} catch (Exception e) {
			//e.printStackTrace();
			//System.out.println("erreur attendue = " + e.getMessage());
			//logger.error("erreur attendue pour division par 0",e);
			logger.error("erreur attendue pour division par 0",e.getMessage());
		}
	}
	
	@Test
    public void testRacineCarree() {
		Calcul objCalcul = new Calcul();
		double res1;
		res1 = objCalcul.racineCarree(25.0);
		System.out.println("res1="+res1);
		
		//logger.debug("res1="+res1);
		//assertTrue(res1>=4.9999999 && res1<= 5.0000001);
		//assertEquals(valeurAttendue, valeurObtenue,deltaPres)
		assertEquals(5.0,res1,0.000001);
	}
	
	@Test
    public void testRacineCarreeAvecException() {
		Calcul objCalcul = new Calcul();
		try {
			double res1 = objCalcul.racineCarree(-12);
			System.out.println("res1="+res1);
			fail("si aucune exception ne remonte , c'est pas normal");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("erreur attendue = " + e.getMessage());
		}
	}

}
