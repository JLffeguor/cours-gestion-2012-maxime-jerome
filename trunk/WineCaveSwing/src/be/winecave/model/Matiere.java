package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class Matiere extends BaseEntity{

	private String Nom_matiere;

	public String getNom_matiere() {
		return Nom_matiere;
	}

	public void setNom_matiere(String nom_matiere) {
		Nom_matiere = nom_matiere;
	}
}
