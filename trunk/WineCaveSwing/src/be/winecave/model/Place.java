package be.winecave.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Place extends BaseEntity {
	@ManyToOne
	private Emplacement emplacement;

	public Emplacement getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}
}
