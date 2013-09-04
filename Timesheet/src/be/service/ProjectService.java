package be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.model.Project;
import be.model.User;
import be.model.User.Role;
import be.repository.ProjectRepository;
import be.repository.UserRepository;

@Service
public class ProjectService {

	@Autowired   private UserRepository userRepository;
	@Autowired   private ProjectRepository projectRepository;

	public Project createProject(String projectName,String description,String projectManagerUserName,List<String> assignedUser) {
		Project result = new Project();
		result.setName(projectName);
		result.setDescription(description);

		User projectManager = userRepository.getUserByUserName(projectManagerUserName);
		result.addMember(projectManager, Role.PROJECT_MANAGER);

		User user = null;
		for(String userName : assignedUser) {
			user = userRepository.getUserByUserName(userName);
			if(user != null) {
				result.addMember(projectManager, Role.USER);
			}
			//TODO make something when user not found
		}

		projectRepository.persist(result);

		return result;

	}

}
