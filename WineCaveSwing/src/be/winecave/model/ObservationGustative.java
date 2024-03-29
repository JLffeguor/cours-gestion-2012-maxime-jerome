package be.winecave.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ObservationGustative extends BaseEntity {

	private String commentaireEnBouche;
	private String commentaireFinale;
	@ManyToOne
	private Squelette squelette;
	@ManyToOne
	private Matiere matiere;
	@ManyToOne
	private DominanteGustative dominanteGustative;
	@ManyToOne
	private PuissanceAromatique puissanceAromatique;
	
	
	public String getCommentaireEnBouche() {
		return commentaireEnBouche;
	}
	public void setCommentaireEnBouche(String commentaireEnBouche) {
		this.commentaireEnBouche = commentaireEnBouche;
	}
	public String getCommentaireFinale() {
		return commentaireFinale;
	}
	public void setCommentaireFinale(String commentaireFinale) {
		this.commentaireFinale = commentaireFinale;
	}
	public Squelette getSquelette() {
		return squelette;
	}
	public void setSquelette(Squelette squelette) {
		this.squelette = squelette;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public DominanteGustative getDominanteGustative() {
		return dominanteGustative;
	}
	public void setDominanteGustative(DominanteGustative dominanteGustative) {
		this.dominanteGustative = dominanteGustative;
	}
	public PuissanceAromatique getPuissanceAromatique() {
		return puissanceAromatique;
	}
	public void setPuissanceAromatique(PuissanceAromatique puissanceAromatique) {
		this.puissanceAromatique = puissanceAromatique;
	}
	
	
}
