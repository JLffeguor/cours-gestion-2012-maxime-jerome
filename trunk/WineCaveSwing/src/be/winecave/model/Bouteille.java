package be.winecave.model;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotBlank;

public class Bouteille {

	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom_bouteille;
	
	@Column(nullable=false)
	@NotBlank
	private int capaciteLitre;
	
	public int getCapaciteLitre() {
		return capaciteLitre;
	}
	public void setCapaciteLitre(int capaciteLitre) {
		this.capaciteLitre = capaciteLitre;
	}
	public String getNom() {
		return nom_bouteille;
	}
	public void setNom(String nom) {
		this.nom_bouteille = nom;
	}
	
}
