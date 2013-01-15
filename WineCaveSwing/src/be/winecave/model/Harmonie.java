package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class Harmonie extends BaseEntity{

	
	private String nom_harmonie;

	public String getNom_harmonie() {
		return nom_harmonie;
	}

	public void setNom_harmonie(String nom_harmonie) {
		this.nom_harmonie = nom_harmonie;
	}
}
