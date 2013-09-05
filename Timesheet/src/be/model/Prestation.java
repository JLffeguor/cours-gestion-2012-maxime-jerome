package be.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import be.model.User.Role;

@Entity
public class Prestation extends AbstractTask {
	
	private User prestataire;
	private Date startDate;
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	private Date endDate;
	
	@Override
	public Map<User, Role> getAssignedUsers() {
		Map<User, Role> result = new HashMap<>();
		result.put(prestataire, this.getParent().getAssignedUsers().get(prestataire));
		
		return Collections.unmodifiableMap(result);
	}

	@Override
	public Double getWorkedHours() {
		long millisecondediff = endDate.getTime() - startDate.getTime();
		return (double) (millisecondediff / 1000.0 / 60.0 / 60.0);
	}

	/**
	 * retourne les heures prévues de la tâche
	 */
	@Override
	public double getPlannedHours() {
		return this.getParent().getPlannedHours();
	}

	public User getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(User prestataire) {
		this.prestataire = prestataire;
	}

}
