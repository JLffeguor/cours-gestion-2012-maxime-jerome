package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class ObservationVisuelle extends BaseEntity{

	private String commentaires;
	private Teinte teinte;
	private IntensiteVisuelle intensiteVisuelle;
}
