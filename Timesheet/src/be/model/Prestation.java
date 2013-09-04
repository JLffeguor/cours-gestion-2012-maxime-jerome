package be.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import be.model.User.Role;

@Entity
public class Prestation extends AbstractTask {
	
	private User prestataire;
	private int workedHours;

	@Override
	public Map<User, String> getAssignedUsers() {
		Map<User, String> result = new HashMap<>();
		result.put(prestataire, this.getParent().getAssignedUsers().get(prestataire));
		
		return Collections.unmodifiableMap(result);
	}

	@Override
	public Integer getWorkedHours() {
		return workedHours;
	}

	/**
	 * retourne les heures prévues de la tâche
	 */
	@Override
	public Integer getPlannedHours() {
		return this.getParent().getPlannedHours();
	}

	public User getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(User prestataire) {
		this.prestataire = prestataire;
	}

}
