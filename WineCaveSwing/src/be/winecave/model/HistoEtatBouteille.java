package be.winecave.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;
/**
 * classe pour represententer un changement de place ou d'état d'une bouteille de vin
 * lors de ce changement une nouvelle instance est crée et ne sera jamais modifiée
 */
@Entity
public class HistoEtatBouteille extends BaseEntity {
	@OneToOne
	@NotBlank
	private EtatBouteille_Vin_Place etatBouteille_Vin_Place;
	@Column(nullable=false)
	@NotBlank
	private Date mouvement;
	
	public HistoEtatBouteille(){}
	public HistoEtatBouteille(EtatBouteille_Vin_Place etatBouteille_Vin_Place,
			Date mouvement) {
		this.etatBouteille_Vin_Place = etatBouteille_Vin_Place;
		this.mouvement = mouvement;
	}
	
	
	public EtatBouteille_Vin_Place getEtatBouteille_Vin_Place() {
		return etatBouteille_Vin_Place;
	}
	public Date getMouvement() {
		return mouvement;
	}
}
