package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class IntensiteVisuelle extends BaseEntity{

	private String nomIntensiteVisuelle;

	public String getNomIntensiteVisuelle() {
		return nomIntensiteVisuelle;
	}

	public void setNomIntensiteVisuelle(String nomIntensiteVisuelle) {
		this.nomIntensiteVisuelle = nomIntensiteVisuelle;
	}
}
