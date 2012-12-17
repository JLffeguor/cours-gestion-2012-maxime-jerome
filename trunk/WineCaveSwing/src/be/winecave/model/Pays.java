package be.winecave.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Pays extends Region {

	public Pays() {
	}
	
	public Pays(String nom) {
		super(nom);
	}

	public List<RegionViticole> getRegions() {
		return super.getEnfants();
	}
}