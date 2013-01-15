package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class ObservationVisuelle extends BaseEntity{

	private String commentaires;
	private Teinte teinte;
	private IntensiteVisuelle intensiteVisuelle;
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public Teinte getTeinte() {
		return teinte;
	}
	public void setTeinte(Teinte teinte) {
		this.teinte = teinte;
	}
	public IntensiteVisuelle getIntensiteVisuelle() {
		return intensiteVisuelle;
	}
	public void setIntensiteVisuelle(IntensiteVisuelle intensiteVisuelle) {
		this.intensiteVisuelle = intensiteVisuelle;
	}
}
