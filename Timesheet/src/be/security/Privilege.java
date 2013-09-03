package be.security;

//import be.loop.jbb.bo.corp.CorpUser.CorporateRole;


import be.model.User;
import be.model.User.Role;

public enum Privilege {

    // Users management
    MANAGE_USERS("Manage users (create / edit / delete / rename)", Role.ADMIN), //ok
 
	// News related privileges
	MANAGE_PROJECT("Manage all project", Role.PROJECT_ADMIN),
    MANAGE_CURRENT_PROJECT("manage current project", Role.PROJECT_MANAGER);
    
	String name;
	Role associatedRole;


	Privilege(String aName, Role aRole) {
	    this.name = aName;
		this.associatedRole = aRole;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isPartOfUserPrivileges(User user){
		if(user == null){
			return false;
		}
		return SecurityContext.getAllAssociatedPrivileges(user).contains(this);
	}

	public Role getAssociatedRole() {
		return this.associatedRole;
	}

	
	public void setAssociatedRole(Role associatedRole) {
		this.associatedRole = associatedRole;
	}


	public boolean isPrivilegeOfUser(User user) {
		return user.getPrivileges().contains(this);
		  
	}
	
}