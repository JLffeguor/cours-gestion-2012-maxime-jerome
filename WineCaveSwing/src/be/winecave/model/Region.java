package be.winecave.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

/**
 * super classe région étant soit un pays , une région ou une sous région
 * en db représentera une seule table avec les classes par défaut
 * @author maxime
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Region extends BaseEntity {

	//TODO definire une taille maximum --maxime 11/12/12
	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;
	
	/**
	 * un pays a des enfants de type RegionViticole 
	 * et une régionViticole peut en avoir aussi
	 */
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
	private List<RegionViticole> enfants;
	
	public Region() {
		
	}
	
	public Region(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<RegionViticole> getEnfants() {
		return enfants;
	}
}