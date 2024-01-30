package tp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.dto.geo_api_gouv_fr.Commune;
import tp.dto.zippopotam.ZippopotamResponse;
import tp.util.MyHttp2Util;

public class TestMyHttp2Util {
	
	private static Logger logger = LoggerFactory.getLogger(TestMyHttp2Util.class);
	
	private MyHttp2Util myHttp2Util = MyHttp2Util.INSTANCE;
	
	
	@Test
	public void testFetchGeoApiGouvFrCommune() {
		List<Commune> communes = myHttp2Util.fetchList("https://geo.api.gouv.fr/communes?codePostal=78000", Commune.class);
		assertNotNull(communes);
		logger.debug("communes="+communes);
	}
	
	@Test
	public void testFetchZippopotam() {
		ZippopotamResponse zippopotamResponse = myHttp2Util.fetch("http://api.zippopotam.us/fr/75001", ZippopotamResponse.class);
		assertNotNull(zippopotamResponse);
		logger.debug("zippopotamResponse="+zippopotamResponse);
	}
	

}
