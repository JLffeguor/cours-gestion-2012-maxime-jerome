package JUnit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import service.UserService;

public class User {

	private String matricule = "matriTest24";
	private String adress = "rue du poney 60b P-6402 poneyville";
	private int childrenNumber = 240000;
	private int phone = 0000000001;

	private static UserService userService;

	@BeforeClass
	public static void instantiateClasses() {
		userService = new UserService();
	}

	@Test
	public void RegisterNewUser() {
		try {
			userService.registerUser(adress, childrenNumber, matricule, phone);
		} catch (Exception e) {
			fail("can't register an use");
		}
	}

}
