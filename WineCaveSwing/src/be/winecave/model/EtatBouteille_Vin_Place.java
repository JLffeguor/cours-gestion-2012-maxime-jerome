package be.winecave.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * classe utilisée pour la relation ternaire entre etatBouteille,Vin et Place
 *
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"etatBouteille_id", "place_id" , "vin_id"}))
public class EtatBouteille_Vin_Place extends BaseEntity{
	@OneToOne
	private EtatBouteille etatBouteille;
	@OneToOne
	private Place place;
	@OneToOne
	private Vin vin;
	
	@OneToOne(mappedBy="etatBouteille_Vin_Place")
	private HistoEtatBouteille histoEtatBouteille;
	
	//seulement un constructeur et pas de setter
	//en cas de changement il y a creation, d'un nouveau EtatBouteille_Vin_Place
	//et stockage de l'ancien dans un HistoEtatBouteille
	public EtatBouteille_Vin_Place() {}
	public EtatBouteille_Vin_Place(EtatBouteille etatBouteille, Place place, Vin vin) {
		this.etatBouteille = etatBouteille;
		this.place = place;
		this.vin = vin;
	}
	
	public EtatBouteille getEtatBouteille() {
		return etatBouteille;
	}
	public Place getPlace() {
		return place;
	}
	public Vin getVin() {
		return vin;
	}
	
	public HistoEtatBouteille getHistoEtatBouteille() {
		return histoEtatBouteille;
	}
}
