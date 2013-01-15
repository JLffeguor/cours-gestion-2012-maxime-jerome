package be.winecave.model;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Degustation extends BaseEntity {

	private Date date_degustation;
	private Carafage carafage;
	private QualiteEnsemble qualiteEnsemble;
	private ObservationGustative observationGustative;
	private ObservationOlphactive observationOlphactive;
	private ObservationVisuelle observationVisuelle;

	public Date getDate_degustation() {
		return date_degustation;
	}

	public void setDate_degustation(Date date_degustation) {
		this.date_degustation = date_degustation;
	}
}
