package be.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

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
	public Map<User, String> getAssignedUsers() {
		Map<User, String> result = new HashMap<>();
		result.put(prestataire, this.getParent().getAssignedUsers().get(prestataire));
		
		return Collections.unmodifiableMap(result);
	}

	@Override
	public Integer getWorkedHours() {
		long millisecondediff = endDate.getTime() - startDate.getTime();
		return (int) (millisecondediff / 1000 / 60 / 60);
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
