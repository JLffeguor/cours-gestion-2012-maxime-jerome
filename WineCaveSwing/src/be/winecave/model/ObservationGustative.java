package be.winecave.model;

import javax.persistence.Entity;


@Entity
public class ObservationGustative extends BaseEntity {

	private String commentaireEnBouche;
	private String commentaireFinale;
	private Squelette squelette;
	private Matiere matiere;
	private DominanteGustative dominanteGustative;
	private PuissanceAromatique puissanceAromatique;
	
	
}
