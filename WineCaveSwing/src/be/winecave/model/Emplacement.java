package be.winecave.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Emplacement extends BaseEntity {
	@ManyToOne
	private Cave cave;
	
	//TODO definir une taille maximum --maxime 11/12/12
	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;
	
	@OneToMany(mappedBy="emplacement")
	private List<Place> places;

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Place> getPlaces() {
		return places;
	}
	
	

}
