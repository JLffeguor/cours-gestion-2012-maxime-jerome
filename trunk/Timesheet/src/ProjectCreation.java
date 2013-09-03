import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.model.Project;
import be.model.User;
import be.model.User.Role;
import be.repository.ProjectRepository;
import be.repository.UserRepository;
import be.web.ContextUtil;


public class ProjectCreation {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContextUtil.contextInitialized(context);
		
		Project project = new Project();
		
		project.setName("projet 1");
		project.addMember( ((UserRepository) ContextUtil.getSpringBean("userRepository")).getUserByUserName("plop") , Role.PROJECT_MANAGER);
		project.addMember( ((UserRepository) ContextUtil.getSpringBean("userRepository")).getUserByUserName("plep") , Role.USER);
		project.addMember( ((UserRepository) ContextUtil.getSpringBean("userRepository")).getUserByUserName("plup") , Role.USER);
		
		((ProjectRepository) ContextUtil.getSpringBean("projectRepository")).persist(project);
		//user = ((UserRepository) ContextUtil.getSpringBean("userRepository")).merge(user);
		
		System.out.println("project id" + project.getId());
		
		project = new Project();
		project.setName("projet 2");
		project.addMember(((UserRepository) ContextUtil.getSpringBean("userRepository")).getUserByUserName("plop"), Role.PROJECT_MANAGER);
		
		((ProjectRepository) ContextUtil.getSpringBean("projectRepository")).persist(project);
		//user = ((UserRepository) ContextUtil.getSpringBean("userRepository")).merge(user);
		
		System.out.println("project id" + project.getId());
	}

}
