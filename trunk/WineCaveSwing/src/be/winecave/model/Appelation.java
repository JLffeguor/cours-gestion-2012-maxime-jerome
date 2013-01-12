package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class Appelation extends BaseEntity {
	
	private String nom;
	
	public Appelation() {
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
