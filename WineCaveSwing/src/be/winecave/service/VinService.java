package be.winecave.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.winecave.exception.NonImplementedException;
import be.winecave.model.Bouteille;
import be.winecave.model.Categorie;
import be.winecave.model.Classement;
import be.winecave.model.Conservation;
import be.winecave.model.Couleur;
import be.winecave.model.PaysViticole;
import be.winecave.model.Region;
import be.winecave.model.RegionViticole;
import be.winecave.model.Vin;
import be.winecave.repository.BouteilleRepository;
import be.winecave.repository.CategorieRepository;
import be.winecave.repository.ClassementRepository;
import be.winecave.repository.ConservationRepository;
import be.winecave.repository.CouleurRepository;
import be.winecave.repository.PaysViticoleRepository;
import be.winecave.repository.RegionViticoleRepository;
import be.winecave.repository.VinRepository;

@Service
public class VinService {
    @PersistenceContext
    EntityManager em;//only used to check state of entity
	
	@Autowired
	RegionViticoleRepository regionViticoleRepository;
	@Autowired
	PaysViticoleRepository paysViticoleRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	ConservationRepository conservationRepository;
	@Autowired
	CouleurRepository couleurRepository;
	@Autowired
	BouteilleRepository bouteilleRepository;
	@Autowired
	ClassementRepository classementRepository;
	@Autowired
	VinRepository vinRepository;

	public Vin creerVin(String nomRegion,
						String nomCategorie,
						String nomCouleur,
						String nomBouteille,
						String nomClassement,
						String anneeMinimumConservation,String anneeMaximumConservation,String anneeDebutApogee,String anneeFinApogee,double temperatureMinimum,double temperatureMaximum,
						Vin vin) {
		//TODO assert user can do this
		//TODO check if special categorie "vin de pays , vin de table " user can add specific region but only land
		///check right vin parameter
		if(vin == null){
			throw new IllegalArgumentException("le paramètre vin ne peut pas être null");
		}
		//un vin doit avoir au minimum un nom donc on regarde si le nom n'est pas null ou vide
		if(vin.getNom() == null || vin.getNom().isEmpty()){
			throw new IllegalArgumentException("le nom du vin ne doit pas être vide");//TODO créer une exception pour els champs empty ? --maxime 28/12/12
		}
		
		////retrieve entities in db
		Region region = regionViticoleRepository.findByName(nomRegion);
		if (region == null) {
			region = paysViticoleRepository.findByName(nomRegion);
		}
		Categorie categorie = categorieRepository.findByName(nomCategorie);
		Couleur couleur = couleurRepository.findByName(nomCouleur);
		Bouteille bouteille = bouteilleRepository.findByName(nomBouteille);
		Classement classement = classementRepository.findByName(nomClassement);
		
		///delegate to second method
		Vin newVin = creerVin(region, 
						   	  categorie, 
						   	  couleur, 
						   	  bouteille, 
						   	  classement, 
						   	  anneeMinimumConservation, anneeMaximumConservation, anneeDebutApogee, anneeFinApogee, temperatureMinimum, temperatureMaximum, 
						   	  vin);
		
		return newVin;
	}
	
	public Vin creerVin(Region region, 
						Categorie categorie,
						Couleur couleur, 
						Bouteille bouteille,
						Classement classement, 
						String anneeMinimumConservation,String anneeMaximumConservation,String anneeDebutApogee,String anneeFinApogee,double temperatureMinimum,double temperatureMaximum, 
						Vin vin) {
		
		////check in the db if there is already exact same conservation
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		Conservation conservation = null;
		try {
			conservation = conservationRepository.findAnExactConservation(yearFormat.parse(anneeMinimumConservation), yearFormat.parse(anneeMaximumConservation), yearFormat.parse(anneeDebutApogee), yearFormat.parse(anneeFinApogee), temperatureMinimum, temperatureMaximum);
			if ( conservation == null ) {
				conservation = new Conservation(yearFormat.parse(anneeMinimumConservation), yearFormat.parse(anneeMaximumConservation), yearFormat.parse(anneeDebutApogee), yearFormat.parse(anneeFinApogee), temperatureMinimum, temperatureMaximum);
			}
		} catch (ParseException e1) {
			throw new IllegalArgumentException("la date de conservation du vin est dans un mauvais format");
		}
		
		/////ensure linked entities managed
		if (region != null) {
			if(region instanceof RegionViticole) {
				if(region.getId() == null) {
					regionViticoleRepository.persist((RegionViticole) region);
				}
				region = regionViticoleRepository.merge((RegionViticole) region);
			} else if (region instanceof PaysViticole) {
				if(region.getId() == null) {
					paysViticoleRepository.persist((PaysViticole) region);
				}
				region = paysViticoleRepository.merge((PaysViticole) region);
			}
			vin.setRegion(region);
		}
			
		if(categorie != null) {
			if(categorie.getId() == null) {
				categorieRepository.persist(categorie);
			}
			categorie = categorieRepository.merge(categorie);
			vin.setCategorie(categorie);
		}
			
		if(couleur != null){
			if(couleur.getId() == null) {
				couleurRepository.persist(couleur);
			}
			couleur = couleurRepository.merge(couleur);
			vin.setCouleur(couleur);
		}
		if(bouteille != null) {
			if(bouteille.getId() == null) {
				bouteilleRepository.persist(bouteille);
			}
			bouteille = bouteilleRepository.merge(bouteille);
			vin.setBouteille(bouteille);
		}
		if(classement != null) {
			if(classement.getId() == null) {
				classementRepository.persist(classement);
			}
			classement = classementRepository.merge(classement);
			vin.setClassement(classement);
		}
		if(conservation != null) {
			if(conservation.getId() == null) {
				conservationRepository.persist(conservation);
			}
			conservation = conservationRepository.merge(conservation);
			vin.setConservation(conservation);
		}
		
		///persist or merge new entities
		if(conservation.getId() == null) {
			conservationRepository.persist(conservation);
		}
		if(vin.getId() == null) {
			vinRepository.persist(vin);
		}
		
		conservationRepository.merge(conservation);
		vinRepository.merge(vin);
		
		return vin;

	}
	
	//TODO methode qui supprime le vin car le vin est lié à beacoup d'entités donc supprimé , ou pas , les entités liées
	void supprimerVin() {
		throw new NonImplementedException("supprimerVin()");
	}
}
