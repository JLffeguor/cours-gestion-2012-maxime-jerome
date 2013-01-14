package be.winecave.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Emplacement extends BaseEntity {
	@ManyToOne
	private Cave cave;
	@OneToMany(mappedBy="emplacement")
	private List<Place> places;
	
	//TODO definir une taille maximum --maxime 11/12/12
	@Column(nullable=false,unique=true)
	@NotBlank
	private String nom;
	@Column(nullable=false,unique=true)
	private int nombreColonne; //valeur de x maximum pour les places contenues
	@Column(nullable=false,unique=true)
	private int nombreLigne; //valeur de y maximum pour les places contenues
	
	public Emplacement() {}
	public Emplacement(String nom, int nombreColonne, int nombreLigne) {
		this.nom = nom;
		this.nombreColonne = nombreColonne;
		this.nombreLigne = nombreLigne;
	}

	public Cave getCave() {
		return cave;
	}
	public void setCave(Cave cave) {
		this.cave = cave;
	}
	public List<Place> getPlaces() {
		return places;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNombreColonne() {
		return nombreColonne;
	}
	public void setNombreColonne(int nombreColonne) {
		this.nombreColonne = nombreColonne;
	}
	public int getNombreLigne() {
		return nombreLigne;
	}
	public void setNombreLigne(int nombreLigne) {
		this.nombreLigne = nombreLigne;
	}
}
