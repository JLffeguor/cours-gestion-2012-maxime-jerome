package be.winecave.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Couleur extends BaseEntity{

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
