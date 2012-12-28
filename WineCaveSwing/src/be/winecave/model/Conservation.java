package be.winecave.model;

import java.util.Date;

import javax.persistence.Entity;
@Entity
public class Conservation extends BaseEntity {
	
	private Date minimum;
	private Date maximum;
	private Date debutApogee;
	private Date finApogee;
	private double temperature;
	
	//TODO classe de maintenance qui supprimerait les conservation non réliée a un vin
	
	//mise en place d'un constructeur (et un vide obligatoire pour spring/hibernate)
	//et suppression des setters car si une conservation est partagée par plusieurs vin
	//car il est obligatoire d'en créer une autre instance en cas de modification
	//sous peine de corrompre les données des vins dont la conservation n'est pas senée être modififée
	public Conservation() {}
	public Conservation(Date minimum, Date maximum,	Date debutApogee, Date finApogee, double temperature) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.debutApogee = debutApogee;
		this.finApogee = finApogee;
		this.temperature = temperature;
	}
	
	public Date getMinimum() {
		return minimum;
	}
	public Date getMaximum() {
		return maximum;
	}
	public Date getDebutApogee() {
		return debutApogee;
	}
	public Date getFinApogee() {
		return finApogee;
	}
	public double getTemperature() {
		return temperature;
	}
}
