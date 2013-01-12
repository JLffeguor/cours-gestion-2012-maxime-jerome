package be.winecave.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class PaysViticole extends Region {
	
	public PaysViticole() {
	}
	
	public PaysViticole(String nom) {
		super(nom);
	}
	
	public List<RegionViticole> getRegionsEnfant() {
		ArrayList<RegionViticole> result = new ArrayList<>(getEnfants().size());
		for(Region region : getEnfants()) {
			if(region instanceof RegionViticole) {
				result.add((RegionViticole)region);
			}
		}
		return result;
	}
	
	@Override
	Region getParent() {
		if(super.getParent() != null) {
			throw new RuntimeException("bug : un pays ne peut avoir de parent");
		}
		return super.getParent();
	}

	@Override
	void setParent(Region region) {
		if(region != null) {
			throw new RuntimeException("bug : un pays ne peut avoir de parent");//FIXME Runtime or illegalArgument ? --maxime 12/01/12
		}
	}
}