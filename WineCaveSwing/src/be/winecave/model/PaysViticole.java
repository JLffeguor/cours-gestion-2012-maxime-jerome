package be.winecave.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class PaysViticole extends Region {

	public PaysViticole() {
	}
	
	public PaysViticole(String nom) {
		super(nom);
	}

	public List<RegionViticole> getRegions() {
		return super.getEnfants();
	}
}