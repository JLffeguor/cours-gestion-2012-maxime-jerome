package be.winecave.model;

import java.util.Date;

public class EtatBouteille extends BaseEntity {
	
	private boolean consommee;
	private boolean achete;//une bouteille est soit achetée ou reçu donc un seul boolean suffit
	private Date obtention;
	
	public boolean isConsommee() {
		return consommee;
	}
	public void setConsommee(boolean consommee) {
		this.consommee = consommee;
	}
	public boolean isAchete() {
		return achete;
	}
	public void setAchete(boolean achete) {
		this.achete = achete;
	}
	public boolean isReçu() {
		return !isAchete();//si elle est achetée c'ets qu'elle n'a pas été reçue
	}
	public void setReçu(boolean reçu) {
		setAchete(!reçu);//si elle est achetée c'ets qu'elle n'a pas été reçue
	}
	public Date getObtention() {
		return obtention;
	}
	public void setObtention(Date obtention) {
		this.obtention = obtention;
	}
}
