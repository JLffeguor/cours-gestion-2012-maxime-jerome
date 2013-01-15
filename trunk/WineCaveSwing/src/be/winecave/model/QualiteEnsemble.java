package be.winecave.model;

import javax.persistence.Entity;

@Entity
public class QualiteEnsemble extends BaseEntity {

	private String commentaire;
	private String leLendemain;
	private Harmonie harmonie;
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getLeLendemain() {
		return leLendemain;
	}
	public void setLeLendemain(String leLendemain) {
		this.leLendemain = leLendemain;
	}
	public Harmonie getHarmonie() {
		return harmonie;
	}
	public void setHarmonie(Harmonie harmonie) {
		this.harmonie = harmonie;
	}
	
}
