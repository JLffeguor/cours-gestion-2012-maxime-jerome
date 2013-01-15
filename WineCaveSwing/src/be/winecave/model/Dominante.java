package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class Dominante extends BaseEntity{

	private String nom_dominante;

	public String getNom_dominante() {
		return nom_dominante;
	}

	public void setNom_dominante(String nom_dominante) {
		this.nom_dominante = nom_dominante;
	}
	
}
