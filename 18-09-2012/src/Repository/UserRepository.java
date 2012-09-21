package Repository;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import model.Users;


public class UserRepository {

	private final Path path = FileSystems.getDefault().getPath("user.csv");
	private EntityManager<Users> em = new EntityManager<>(path,new Users());

	public void persist(Users user) {
		em.persist(user);
	}
}
