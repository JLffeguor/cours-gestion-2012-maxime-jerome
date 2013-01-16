package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class Matiere extends BaseEntity{

	private String nom_matiere;

	public String getNom_matiere() {
		return nom_matiere;
	}

	public void setNom_matiere(String nom_matiere) {
		nom_matiere = nom_matiere;
	}
}
