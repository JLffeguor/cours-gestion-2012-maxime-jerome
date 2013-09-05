package be.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import be.model.User.Role;

@Entity
public class AssignedUser extends BaseEntity {
	
	@ManyToOne
	private User user;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
