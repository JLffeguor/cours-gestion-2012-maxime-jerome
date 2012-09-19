package Repository;
import model.Users;


public class UserRepository {

	private final String FILE_PATH = "user.csv";
	private EntityManager<Users> em;

	public UserRepository() {
		em = new EntityManager<>(FILE_PATH,new Users());
	}

	public void persist(Users user) {
		em.persist(user);
	}
}
