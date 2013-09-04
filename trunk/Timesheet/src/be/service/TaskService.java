package be.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.exception.UserNotFoundException;
import be.model.Prestation;
import be.model.Project;
import be.model.Task;
import be.model.User;
import be.repository.PrestationRepository;
import be.repository.ProjectRepository;
import be.repository.TaskRepository;
import be.repository.UserRepository;

@Service
public class TaskService {

	@Autowired   private UserRepository userRepository;
	@Autowired   private TaskRepository taskRepository;
	@Autowired   private ProjectRepository projectRepository;
	@Autowired	 private PrestationRepository prestationRepository;

	public Task createTask(long relatedProjetId, int plannedHours, String description,List<String> assignedUser) throws UserNotFoundException {
		
		Project relatedProjet = projectRepository.find(relatedProjetId);
		
		Task result = new Task();
		result.setDescription(description);

		result.setParent(relatedProjet);
		
		User user = null;
		for(String userName : assignedUser) {
			user = userRepository.getUserByUserName(userName);
			
			if(user != null) {
				result.assignUser(user);
			}
			//FIXME make something when usernotfound is throwed
			//TODO make something when user not found
		}

		taskRepository.persist(result);
		
		projectRepository.merge(relatedProjet);
		taskRepository.merge(result);
		
		return result;

	}

	public Prestation addPrestation(long taskId, String description, Date startDate, Date endDate) {
		Task task = taskRepository.find(taskId);
		
		Prestation prestation = new Prestation();
		prestation.setDescription(description);
		prestation.setStartDate(startDate);
		prestation.setEndDate(endDate);
		
		prestation.setParent(task);
		
		prestationRepository.persist(prestation);
		
		return prestation;
		
	}

}
