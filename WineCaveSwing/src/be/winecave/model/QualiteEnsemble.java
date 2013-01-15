package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class QualiteEnsemble extends BaseEntity {

	private String commentaire;
	private String leLendemain;
	private Harmonie harmonie;
	
}
