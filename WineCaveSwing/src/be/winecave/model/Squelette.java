package be.winecave.model;

import javax.persistence.Entity;


@Entity
public class Squelette extends BaseEntity{

	private String nomSquelette;

	public String getNomSquelette() {
		return nomSquelette;
	}

	public void setNomSquelette(String nomSquelette) {
		this.nomSquelette = nomSquelette;
	}
}
