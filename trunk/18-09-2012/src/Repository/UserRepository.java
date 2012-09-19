package Repository;
import model.User;


public class UserRepository {

	private final String FILE_PATH = "18-09-2012.txt";
	private EntityManager<User> em;

	public UserRepository() {
		em = new EntityManager<>(FILE_PATH);
	}

	public void persist(User user) {
		em.persist(user);
	}
}
