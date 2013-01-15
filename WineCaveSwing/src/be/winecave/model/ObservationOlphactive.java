package be.winecave.model;

import javax.persistence.Entity;


@Entity
public class ObservationOlphactive extends BaseEntity{

	private String composantes;
	private String commentaires;
	private Finesse finesse;
	private Dominante dominante;
	public String getComposantes() {
		return composantes;
	}
	public void setComposantes(String composantes) {
		this.composantes = composantes;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public Finesse getFinesse() {
		return finesse;
	}
	public void setFinesse(Finesse finesse) {
		this.finesse = finesse;
	}
	public Dominante getDominante() {
		return dominante;
	}
	public void setDominante(Dominante dominante) {
		this.dominante = dominante;
	}
	
	
}
