package be.winecave.model;

import javax.persistence.Entity;


@Entity
public class ObservationOlphactive extends BaseEntity{

	private String composantes;
	private String commentaires;
	private Finesse finesse;
	private Dominante dominante;
	
	
}
