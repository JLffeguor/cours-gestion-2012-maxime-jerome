package be.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import be.model.User.Role;

@Entity
public class Project extends AbstractTask {
	
	@ElementCollection
	private Map<User,Role> projectMembers;
	
	private String name;

	/**
	 * retourne la liste des membres travaillant dans ce projety=
	 */
	@Override
	public Map<User, Role> getAssignedUsers() {
		return projectMembers;
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

}
