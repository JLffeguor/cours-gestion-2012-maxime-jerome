package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class Teinte extends BaseEntity{
	
	private String nomTeinte;

	public String getNomTeinte() {
		return nomTeinte;
	}

	public void setNomTeinte(String nomTeinte) {
		this.nomTeinte = nomTeinte;
	}

}
