import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.exception.InvalidPasswordException;
import be.exception.UserAlreadyExistsException;
import be.exception.UserNotFoundException;
import be.model.User;
import be.model.User.Role;
import be.repository.UserRepository;
import be.service.LoginService;
import be.service.UserService;
import be.util.SecurityUtils;
import be.web.ContextUtil;


public class UserCreation {
	
	private static ApplicationContext context;

	public static void main(String[] args) throws UserAlreadyExistsException, UserNotFoundException, InvalidPasswordException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContextUtil.contextInitialized(context);
		
		User user = new User();
		user.setUserName("admin");
		user.setPassword(SecurityUtils.md5Encode("admin"));
		user.setRole(Role.ADMIN);
		
		((UserRepository) ContextUtil.getSpringBean("userRepository")).persist(user);
		
		System.out.println("user id" + user.getId());
		
		user = ((UserService) ContextUtil.getSpringBean("userService")).registerUser("plep", "plop");
		System.out.println("user id" + user.getId());
		
		user = ((UserService) ContextUtil.getSpringBean("userService")).registerUser("plup", "plop");
		System.out.println("user id" + user.getId());
		
		user = ((UserService) ContextUtil.getSpringBean("userService")).registerUser("plap", "plop");
		System.out.println("user id" + user.getId());
		
		user = ((UserService) ContextUtil.getSpringBean("userService")).registerUser("plop", "plop");
		System.out.println("user id" + user.getId());
		
		//must comment session init to work
//		user = ((LoginService) ContextUtil.getSpringBean("loginService")).login("plap", "plop", user.getId());
//		System.out.println("user logged by id" + user.getId());
//		user = ((LoginService) ContextUtil.getSpringBean("loginService")).login("plap", "plop", null);
//		System.out.println("user logged by id" + user.getId());
		//to test password exception
//		user = ((LoginService) ContextUtil.getSpringBean("loginService")).login("plap", "pleplepleple", null);
//		System.out.println("user logged by id" + user.getId());
	}

}
