package be.winecave.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Bouteille extends BaseEntity{

	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;
	
	@Column(nullable=false)
	private Double capaciteLitre;
	
	public Double getCapaciteLitre() {
		return capaciteLitre;
	}
	public void setCapaciteLitre(Double capaciteLitre) {
		this.capaciteLitre = capaciteLitre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
