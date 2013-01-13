import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.winecave.model.Vin;
import be.winecave.service.VinService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CreationVin {
	
	//TODO add vin with vinservice
	//TODO test can add pays , region or sous region
	//TODO test if NullObjectException throwed when add vin whit unexisting : Region(pays,region,sous) , categorie, couleur, bouteille, classement
	//TODO test notauthorized user cannot create
	
	@Resource
	VinService vinService;

	@Test
	public void nullVin() {
		try {
			vinService.creerVin("", null, null, null, null, null, null, null, null, 0, 0, null);
		} catch (IllegalArgumentException e) {
			String message = e.getMessage();
			assertTrue(message.equalsIgnoreCase("le paramètre vin ne peut pas être null"));
		}
	}
	
	@Test
	public void EmptyName() {
		Vin test = new Vin();
		test.setNom(null);
		try {
			vinService.creerVin("", null, null, null, null, null, null, null, null, 0, 0, test);
		} catch (IllegalArgumentException e) {
			String message = e.getMessage();
			assertTrue(message.equalsIgnoreCase("le nom du vin ne doit pas être vide"));
		}
	}
	
	@Test
	public void newVin() {
		Vin test = new Vin();
		
		test.setNom("testnom");
		test.setCommentaire("testCommentaire");
		test.setCuvee("test cuvee");
		test.setDegre(1.1);
		test.setNote(5);
		test.setCepage("50% moi");
		test.setProducteur("lui");
		
		test = vinService.creerVin("France", "Bieres", "rouge", "magnum", "Cru Artisan", "2012", "2013", "2015", "2016", 0.5, 0.5, test);
		
		System.out.println(test.getId());
		//todo retrouver le vin dans la db et vérifié les infos
	}

}
