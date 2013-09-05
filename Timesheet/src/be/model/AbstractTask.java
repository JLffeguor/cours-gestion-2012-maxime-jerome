package be.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import be.model.User.Role;

@Entity
public abstract class AbstractTask extends BaseEntity {
    
	@OneToMany(mappedBy = "parent", fetch=FetchType.LAZY)  
	private List<AbstractTask> children = new ArrayList<>();
    
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(nullable = true)
	private AbstractTask parent;
	
	private String description;
	
	/**
	 * pour un projet ou pour une tâche retourne les utilisateurs assignés et pour une prestation , le prestataire
	 */
	public abstract Map<User, Role> getAssignedUsers();
    
	/**
	 * retourne les heure prestées
	 * @return
	 */
	public abstract Double getWorkedHours();
	
	/**
	 * retourne les heures prévues
	 * @return
	 */
	public abstract double getPlannedHours();
	

	public List<AbstractTask> getChildren() {
		return children;
	}

	public void setChildren(List<AbstractTask> children) {
		this.children = children;
	}

	public AbstractTask getParent() {
		return parent;
	}

	public void setParent(AbstractTask parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
