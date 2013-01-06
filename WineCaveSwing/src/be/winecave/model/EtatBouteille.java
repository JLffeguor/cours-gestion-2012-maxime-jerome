package be.winecave.model;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.Type;
@Entity
public class EtatBouteille extends BaseEntity {
	/*
	 * type specified otherwise get a "Wrong column type [..]. Found: bit, expected: boolean" with mysql
	 */
	@Type(type = "org.hibernate.type.TrueFalseType")
	private Boolean consommee;
	/*
	 * type specified otherwise get a "Wrong column type [..]. Found: bit, expected: boolean" with mysql
	 */
	@Type(type = "org.hibernate.type.TrueFalseType")
	private Boolean achete;//une bouteille est soit achetée ou reçu donc un seul boolean suffit
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
