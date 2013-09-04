package be.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import be.model.User.Role;

@Entity
public class Project extends AbstractTask {
	
	@ElementCollection
	private Map<User,String> projectMembers = new HashMap<>();
	
	private String name;

	/**
	 * retourne la liste des membres travaillant dans ce projet
	 */
	@Override
	public Map<User, String> getAssignedUsers() {
		return Collections.unmodifiableMap(projectMembers);
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
	
	public void addMember(User user,Role role) {
		projectMembers.put(user, role.getName());
	}

}
