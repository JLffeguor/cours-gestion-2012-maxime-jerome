package be.winecave.model;

import javax.persistence.Entity;


@Entity
public class Finesse extends BaseEntity{

	private String nom_finesse;

	public String getNom_finesse() {
		return nom_finesse;
	}

	public void setNom_finesse(String nom_finesse) {
		nom_finesse = nom_finesse;
	}
}
