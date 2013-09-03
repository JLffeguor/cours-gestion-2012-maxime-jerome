import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.model.Project;
import be.repository.ProjectRepository;
import be.repository.UserRepository;
import be.web.ContextUtil;


public class ProjectCreation {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContextUtil.contextInitialized(context);
		
		((UserRepository) ContextUtil.getSpringBean("userRepository")).getUserByUserName("plop");
		
		Project project = new Project();
		
		project.setName("projet 1");
		project.
		
		((ProjectRepository) ContextUtil.getSpringBean("projectRepository")).persist(project);
		//user = ((UserRepository) ContextUtil.getSpringBean("userRepository")).merge(user);
		
		System.out.println("project id" + project.getId());
		
		project = new Project();
		project.setName("projet 2");
		
		((ProjectRepository) ContextUtil.getSpringBean("projectRepository")).persist(project);
		//user = ((UserRepository) ContextUtil.getSpringBean("userRepository")).merge(user);
		
		System.out.println("project id" + project.getId());
	}

}
