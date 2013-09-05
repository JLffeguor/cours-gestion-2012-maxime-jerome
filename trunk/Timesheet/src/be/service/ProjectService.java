package be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.model.AssignedUser;
import be.model.Project;
import be.model.User;
import be.model.User.Role;
import be.repository.AssignedUserRepository;
import be.repository.ProjectRepository;
import be.repository.UserRepository;

@Service
public class ProjectService {

	@Autowired   private UserRepository userRepository;
	@Autowired   private ProjectRepository projectRepository;
	@Autowired	 private AssignedUserRepository assignedUserRepository;

	@Transactional
	public Project createProject(String projectName,String description,String projectManagerUserName,List<String> assignedUsers) {
		Project result = new Project();
		result.setName(projectName);
		result.setDescription(description);

		User projectManager = userRepository.getUserByUserName(projectManagerUserName);
		
		AssignedUser assignedUser = new AssignedUser();
		
		assignedUser.setUser(projectManager);
		assignedUser.setRole(Role.PROJECT_MANAGER);
		
		assignedUserRepository.persist(assignedUser);
		
		result.addMember(assignedUser);

		User user = null;
		for(String userName : assignedUsers) {
			user = userRepository.getUserByUserName(userName);
			if(user != null) {
				assignedUser = new AssignedUser();
				
				assignedUser.setUser(user);
				assignedUser.setRole(Role.USER);
				
				assignedUserRepository.persist(assignedUser);
				
				result.addMember(assignedUser);
			}
			//TODO make something when user not found
		}
		
		
		projectRepository.persist(result);

		return result;

	}
	
	@Transactional
	public Project assigneUserToProject(long projetcId,List<String> assignedUsers) {
		Project result = projectRepository.find(projetcId);

		AssignedUser assignedUser = new AssignedUser();
		User user = null;
		for(String userName : assignedUsers) {
			user = userRepository.getUserByUserName(userName);
			if(user != null) {
				assignedUser = new AssignedUser();
				
				assignedUser.setUser(user);
				assignedUser.setRole(Role.USER);
				
				assignedUserRepository.persist(assignedUser);
				
				result.addMember(assignedUser);
			}
			//TODO make something when user not found
		}
		
		
		projectRepository.persist(result);

		return result;

	}

}
