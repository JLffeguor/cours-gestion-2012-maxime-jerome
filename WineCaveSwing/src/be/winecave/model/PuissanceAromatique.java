package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class PuissanceAromatique extends BaseEntity{

	private String Nom_Aromatique;

	public String getNom_Aromatique() {
		return Nom_Aromatique;
	}

	public void setNom_Aromatique(String nom_Aromatique) {
		Nom_Aromatique = nom_Aromatique;
	}
}
