package be.winecave.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Vin extends BaseEntity {
	
	private String millesime;
	@Column(nullable=false)
	@NotBlank
	private String nom;
	private String producteur;//TODO faire un objet producteur ?
	private double degre;
	private int note;//TODO faire un objet note (si on stoque la note en int ou en string si au début on décide de faire une note sur 5 et qu'après on décide la faire sur dix il faudrait refaire toutes les notes...)--maxime 27/12/12
	private String cuvee;//FIXME que veut dire cuvée déjà ?--maxime 27/12/12
	private String cepage;
	private String commentaire;
	
	@ManyToOne
	private Region region;
	@ManyToOne
	private Categorie categorie;
	@ManyToOne
	private Couleur couleur;
	@ManyToOne
	private Bouteille bouteille;
	@ManyToOne
	private Classement classement;
	@ManyToOne
	private Conservation conservation;
	@ManyToOne
	private Appelation appelation;
	@OneToOne
	private Degustation degustation;
	
	public Vin() {}
	public Vin(String nom) {
		this.nom = nom;
	}
	
	
	///*********getters and setters**************///
	
	/////fields/////
	public String getMillesime() {
		return millesime;
	}
	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getProducteur() {
		return producteur;
	}
	public void setProducteur(String producteur) {
		this.producteur = producteur;
	}
	public double getDegre() {
		return degre;
	}
	public void setDegre(double degre) {
		this.degre = degre;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getCuvee() {
		return cuvee;
	}
	public void setCuvee(String cuvee) {
		this.cuvee = cuvee;
	}
	public String getCepage() {
		return cepage;
	}
	public void setCepage(String cepage) {
		this.cepage = cepage;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	//////linked entities//////
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public Bouteille getBouteille() {
		return bouteille;
	}
	public void setBouteille(Bouteille bouteille) {
		this.bouteille = bouteille;
	}
	public Classement getClassement() {
		return classement;
	}
	public void setClassement(Classement classement) {
		this.classement = classement;
	}
	public Conservation getConservation() {
		return conservation;
	}
	public void setConservation(Conservation conservation) {
		this.conservation = conservation;
	}
	public Appelation getAppelation() {
		return appelation;
	}
	public void setAppelation(Appelation appelation) {
		this.appelation = appelation;
	}
	public Degustation getDegustation(){
		return degustation;
	}
	public void setDegustation(Degustation degustation){
		this.degustation = degustation;
	}
}
