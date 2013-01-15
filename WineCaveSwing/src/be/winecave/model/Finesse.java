package be.winecave.model;

import javax.persistence.Entity;


@Entity
public class Finesse extends BaseEntity{

	private String Nom_finesse;

	public String getNom_finesse() {
		return Nom_finesse;
	}

	public void setNom_finesse(String nom_finesse) {
		Nom_finesse = nom_finesse;
	}
}
