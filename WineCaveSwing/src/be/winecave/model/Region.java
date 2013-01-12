package be.winecave.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

/**
 * super classe région étant soit un pays , une région ou une sous région
 * en db représentera une seule table avec les classes par défaut
 * @author maxime
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nom", "parent_id"}))
public abstract class Region extends BaseEntity {

	//TODO definire une taille maximum --maxime 11/12/12
	@Column(nullable=false)
	@NotBlank
	private String nom;
	
	/**
	 * une région peut avoir comme parent :
	 * -une région viticole si c'est donc une sous-région
	 * -un pays si c'est une région viticole
	 */
	@ManyToOne
	private Region parent;
	
	/**
	 * un pays a des enfants de type RegionViticole 
	 * et une régionViticole peut en avoir aussi
	 */
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
	private List<Region> enfants;
	
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
	
	Region getParent() {
		return parent;
	}

	void setParent(Region parent) {
		this.parent = parent;
	}
	
	List<Region> getEnfants() {
		return enfants;
	}

	@Override
	public String toString() {
		return nom;
	}
	
}