package Repository;
import model.User;


public class UserRepository {

	private final String FILE_PATH = "user.csv";
	private EntityManager<User> em;

	public UserRepository() {
		em = new EntityManager<>(FILE_PATH,new User());
	}

	public void persist(User user) {
		em.persist(user);
	}
}
