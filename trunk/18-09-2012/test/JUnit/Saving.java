package JUnit;

import static org.junit.Assert.fail;
import model.Users;

import org.junit.BeforeClass;
import org.junit.Test;

import service.UserService;

public class Saving {

	private static String firstname = "testFirstname";
	private static String name = "testName";	
	private static String matricule = "matriTest24";
	private static String adress = "rue du poney 60b P-6402 poneyville";
	private static int childrenCount = 240000;
	private static int phone = 0000000001;
	
	private static Users test = new Users();

	private static UserService userService = new UserService();

	@BeforeClass
	public static void initialize() {
		
		test.setFirstName(firstname);
		test.setName(name);
		test.setMatricule(matricule);
		test.setAdress(adress);
		test.setChildrenCount(childrenCount);
		test.setPhone(phone);
		
	}

	@Test
	public void RegisterNewUser() {
		try {
			userService.registerUser(test);
		} catch (Exception e) {
			fail("can't register an use");
		}
	}

}
