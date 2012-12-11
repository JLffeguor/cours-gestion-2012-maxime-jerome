package be.winecave.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Region extends BaseEntity {

	@ManyToOne
	private Pays pays;
	
	//TODO definir une taille maximum --maxime 11/12/12
	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;
	
	@OneToMany(mappedBy="region")
	private List<SousRegion> sousRegions;
	
	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<SousRegion> getSousRegions() {
		return sousRegions;
	}
	
}
