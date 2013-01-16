package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class PuissanceAromatique extends BaseEntity{

	private String nom_Aromatique;

	public String getNom_Aromatique() {
		return nom_Aromatique;
	}

	public void setNom_Aromatique(String nom_Aromatique) {
		this.nom_Aromatique = nom_Aromatique;
	}
}
