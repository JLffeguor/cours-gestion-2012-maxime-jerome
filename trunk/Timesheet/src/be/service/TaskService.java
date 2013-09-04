package be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.exception.UserNotFoundException;
import be.model.Task;
import be.model.User;
import be.repository.TaskRepository;
import be.repository.UserRepository;

@Service
public class TaskService {

	@Autowired   private UserRepository userRepository;
	@Autowired   private TaskRepository taskRepository;

	public Task createTask(String description,List<String> assignedUser) throws UserNotFoundException {
		Task result = new Task();
		result.setDescription(description);

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

		return result;

	}

}
