import java.io.IOException;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		User user = new User();
		user.setAdress("machin");
		user.setChildrenNumber(2);
		user.setMatricule("42be");
		user.setPhone(00000000);
		
		SerializeUser serializer;
		try {
			serializer = new SerializeUser();
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		serializer.writeUserToFile(user);

	}

}
