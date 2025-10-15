package tp.pers;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestPersonne  {
	
	private static Logger logger = LoggerFactory.getLogger(TestPersonne.class);
	
	private Personne personne;//à tester
	
	@BeforeEach
	public void setUpBeforeEach() {
		logger.trace("setUpBeforeEach() with JUnit5 @BeforeEach called on " + this);
		personne= new Personne();
	}
	
	@AfterEach
	public void tearDownAfterEach() {
		logger.trace("tearDownAfterEach()  with JUnit5 @AfterEach called on " + this);
	}
	
	@Test
	public void testQuiVaBien() {
		personne.setAge(20);
		logger.debug("estMajeur pour 20 ans="+personne.estMajeur());
		assertTrue(personne.estMajeur()==true);
	}
	
	@Test
	public void test2() {
		//...
	}
	

}
