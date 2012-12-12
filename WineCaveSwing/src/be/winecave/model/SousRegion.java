package be.winecave.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class SousRegion extends BaseEntity {

	@ManyToOne
	private Region region;
	
	//TODO definir une taille maximum --maxime 11/12/12
	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;

	public SousRegion() {
	}
	
	public SousRegion(String nom) {
		this.nom = nom;
	}
	
	
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
