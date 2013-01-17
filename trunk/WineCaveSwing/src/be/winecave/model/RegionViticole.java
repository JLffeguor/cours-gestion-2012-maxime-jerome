package be.winecave.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
/**
 * entité représentant soit une région viticole soit une sous région viticole
 * à determiner en fonction du parent
 * @author maxime
 *
 */
@Entity
public class RegionViticole extends Region {
	

	public RegionViticole() {
	}
	
	public RegionViticole(String nom) {
		super(nom);
	}
	
	public RegionViticole(String nom,Region parent) {
		super(nom);
		this.setParent(parent);
	}
	
	
	public RegionViticole getRegionViticoleParente() {
		return getParent(); //appel de la methode overridée pour appliqué des contraintes spécifiques
	}
	
	public PaysViticole getPaysViticoleParente() {
		return (PaysViticole) super.getParent();
	}

	public List<RegionViticole> getSousRegionViticoleEnfantes() {
		if(super.getParent() instanceof RegionViticole &&// si c'est une sous région 
		   getEnfants() != null) { // et si elle a des sous régions
			throw new RuntimeException("bug : une sous région ne peut contenir d'autres sous régions");
		}
		ArrayList<RegionViticole> result = new ArrayList<>(getEnfants().size());
		for(Region region : getEnfants()) {
			if(region instanceof RegionViticole) {
				result.add((RegionViticole)region);
			}
		}
		
		return result;
	}
	
	@Override
	RegionViticole getParent() {
		if(super.getEnfants() != null) {
			throw new RuntimeException("bug : une sous région ne peut avoir d'enfants");
		}
		return (RegionViticole) super.getParent();
	}
}