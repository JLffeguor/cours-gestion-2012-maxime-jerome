package be.winecave.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
/**
 * entité représentant soit une région viticole soit une sous région viticole
 * à determiner en fonction du parent
 * @author maxime
 *
 */
@Entity
public class RegionViticole extends Region {

	/**
	 * une région viticole peut avoir comme parent :
	 * -une autre région viticole , elle est donc une sous-région
	 * -un pays c'est donc une région viticole
	 * 
	 * ces deux parents sont tous les deux de type region 
	 * ce qui permet de savoir si la présente région viticole est une région ou une sous-région 
	 */
	@ManyToOne
	private Region parent;
	
	public RegionViticole() {
	}
	
	public RegionViticole(String nom) {
		super(nom);
	}

	public Region getParent() {
		return parent;
	}

	public void setParent(Region region) {
		this.parent = region;
	}
	
	@Override
	public List<RegionViticole> getEnfants() {
		//TODO à placer dans une classe service
		if(parent instanceof RegionViticole // si c'est une sous région 
			&& super.getEnfants() != null) { // et si elle a des sous régions
			throw new RuntimeException("bug : " + 
					"une sous région en peut contenir d'autres sous régions");
		}
		return super.getEnfants();
	}
	
	public List<RegionViticole> getSousRegionsViticole() {
		return getEnfants();
	}
}