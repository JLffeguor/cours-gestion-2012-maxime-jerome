package be.winecave.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Couleur extends BaseEntity{

	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
