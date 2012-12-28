package be.winecave.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Cave extends BaseEntity {
	
	//TODO definir une taille maximum --maxime 11/12/12
	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;
	
	@OneToMany(mappedBy="cave")
	private List<Emplacement> emplacements;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Emplacement> getEmplacements() {
		return emplacements;
	}
	
	public User getProprietaire() {
		return getCreatedBy();
	}

}
