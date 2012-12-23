package be.winecave.model;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotBlank;

public class Classement {

	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
