package be.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import be.model.User.Role;

@Entity
public class Project extends AbstractTask {
	
	@OneToMany
	private List<AssignedUser> projectMembers = new ArrayList<>();
	
	private String name;

	/**
	 * retourne la liste des membres travaillant dans ce projet
	 */
	@Override
	public Map<User, Role> getAssignedUsers() {
		Map<User, Role> result = new HashMap<>();
		for (AssignedUser assignedUser : projectMembers) {
			result.put(assignedUser.getUser(), assignedUser.getRole());
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
		int result = 0;
		for(AbstractTask child : this.getChildren()) {
			result += child.getPlannedHours();
		}
		return result;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addMember(AssignedUser assignedUser) {
		projectMembers.add(assignedUser);
	}

}
