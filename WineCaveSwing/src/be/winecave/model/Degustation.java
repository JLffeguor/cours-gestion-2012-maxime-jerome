package be.winecave.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Degustation extends BaseEntity {

	private Date date_degustation;
	@ManyToOne
	private Carafage carafage;
	@OneToOne
	private QualiteEnsemble qualiteEnsemble;
	@OneToOne
	private ObservationGustative observationGustative;
	@OneToOne
	private ObservationOlphactive observationOlphactive;
	@OneToOne
	private ObservationVisuelle observationVisuelle;

	public Date getDate_degustation() {
		return date_degustation;
	}

	public void setDate_degustation(Date date_degustation) {
		this.date_degustation = date_degustation;
	}

	public Carafage getCarafage() {
		return carafage;
	}

	public void setCarafage(Carafage carafage) {
		this.carafage = carafage;
	}

	public QualiteEnsemble getQualiteEnsemble() {
		return qualiteEnsemble;
	}

	public void setQualiteEnsemble(QualiteEnsemble qualiteEnsemble) {
		this.qualiteEnsemble = qualiteEnsemble;
	}

	public ObservationGustative getObservationGustative() {
		return observationGustative;
	}

	public void setObservationGustative(ObservationGustative observationGustative) {
		this.observationGustative = observationGustative;
	}

	public ObservationOlphactive getObservationOlphactive() {
		return observationOlphactive;
	}

	public void setObservationOlphactive(ObservationOlphactive observationOlphactive) {
		this.observationOlphactive = observationOlphactive;
	}

	public ObservationVisuelle getObservationVisuelle() {
		return observationVisuelle;
	}

	public void setObservationVisuelle(ObservationVisuelle observationVisuelle) {
		this.observationVisuelle = observationVisuelle;
	}
}
