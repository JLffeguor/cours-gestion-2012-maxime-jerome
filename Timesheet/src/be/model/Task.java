package be.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import be.exception.UserNotFoundException;
import be.model.User.Role;

@Entity
public class Task extends AbstractTask {

	@ManyToMany
	private List<User> assignedUser = new ArrayList<>();
	private int plannedHours;
	
	@Override
	public Map<User, Role> getAssignedUsers() {
		Map<User, Role> result = new HashMap<>();
		for(User user : assignedUser) {
			result.put(user, this.getParent().getAssignedUsers().get(user));
		}
		return Collections.unmodifiableMap(result);
	}

	@Override
	public Integer getWorkedHours() {
		int result = 0;
		for(AbstractTask child : this.getChildren()) {
			result += child.getWorkedHours();
		}
		return result;
	}

	@Override
	public Integer getPlannedHours() {
		return plannedHours;
	}
	
	/**
	 * assign a new user to this task
	 * @throws UserNotFoundException if the user isn't in the project of this task
	 */
	public void assignUser(User user) throws UserNotFoundException {
		if( ! this.getParent().getAssignedUsers().containsKey(user)) {
			throw new UserNotFoundException(user.getUserName(), "cannot assigned to this task because is not in the project");
		}
		assignedUser.add(user);
	}
	
	public void setPlannedHours(int plannedHours) {
		this.plannedHours = plannedHours;
	}
	

}
