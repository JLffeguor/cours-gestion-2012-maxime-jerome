import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.winecave.model.Emplacement;
import be.winecave.model.Vin;
import be.winecave.service.VinService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class placementVin {

	@Resource
	VinService vinService;
	
	@Test
	public void nonPersistedVin () {
		try {
			vinService.placerVin(new Vin(), null, 0, 0, true);
		} catch(IllegalArgumentException e) {
			String message = e.getMessage();
			assertTrue(message.equals("un vin doit d'abord être persisté avant d'être placé"));
		}
	}
	
	@Test
	public void nullObjectVin () {
		try {
			vinService.placerVin(null, null, 0, 0, true);
		} catch(IllegalArgumentException e) {
			String message = e.getMessage();
			assertTrue(message.equals("un vin doit d'abord être persisté avant d'être placé"));
		}
	}
	
	@Test
	public void placement () {
		Vin test = vinService.creerVin("", null, null, null, null, "", "", "", "", 0, 0, new Vin("testPlacement"));
		vinService.placerVin(test, new Emplacement("testPlacement"), 0, 0, true);
		//TODO supprimer el vin et l'emplacement créé
	}
}
