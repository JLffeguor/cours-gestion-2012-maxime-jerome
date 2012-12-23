package be.winecave.model;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotBlank;

public class Couleur {

	@Column(nullable=false,unique=true)
	@NotBlank
	private String nomCouleur;
	
	public String getNom() {
		return nomCouleur;
	}
	public void setNom(String nom) {
		this.nomCouleur = nom;
	}
}
