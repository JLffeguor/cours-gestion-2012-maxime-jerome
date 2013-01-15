package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class DominanteGustative extends BaseEntity {

	private String nomDominanteGustative;

	public String getNomDominanteGustative() {
		return nomDominanteGustative;
	}

	public void setNomDominanteGustative(String nomDominanteGustative) {
		this.nomDominanteGustative = nomDominanteGustative;
	}
	
}
