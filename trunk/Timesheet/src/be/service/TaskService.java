package be.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.exception.UserNotFoundException;
import be.model.Prestation;
import be.model.Project;
import be.model.Task;
import be.model.Task.State;
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

	@Transactional
	public Prestation addPrestation(long taskId, String description, Date startDate, Date endDate) throws Exception {
		if( startDate.getTime() > endDate.getTime() ) {
			throw new Exception("l'heure de début de la prestation se situe après l'heure de fin");
		}
		
		Task task = taskRepository.find(taskId);
		
		int plannedHour = task.getPlannedHours();
		double workedHour = task.getWorkedHours();
		System.out.println("en millisenconde : " + (endDate.getTime() - startDate.getTime()) );
		workedHour += ((endDate.getTime() - startDate.getTime()) /1000.0 /60.0 /60.0);
		System.out.println(workedHour);
		if( workedHour > plannedHour ) {
			throw new Exception("la prestation en peut être ajoutée car la somme des heures prestées dépasse les heures prévues");
		}
		
		Prestation prestation = new Prestation();
		prestation.setDescription(description);
		prestation.setStartDate(startDate);
		prestation.setEndDate(endDate);
		
		prestation.setParent(task);
		
		prestationRepository.persist(prestation);
		
		if(workedHour == plannedHour) {
			task.setState(State.FINISHED);
			taskRepository.merge(task);
		}
		
		return prestation;
	}

}
