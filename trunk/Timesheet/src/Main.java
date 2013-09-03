import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.model.User;
import be.repository.UserRepository;
import be.web.ContextUtil;


public class Main {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContextUtil.contextInitialized(context);
		
		User user = new User();
		user.setUserName("plep");
		user.setPassword("plop");
		
		((UserRepository) ContextUtil.getSpringBean("userRepository")).persist(user);
		//user = ((UserRepository) ContextUtil.getSpringBean("userRepository")).merge(user);
		
		System.out.println("user id" + user.getId());
	}

}
