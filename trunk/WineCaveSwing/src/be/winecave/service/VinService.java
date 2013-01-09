package be.winecave.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.winecave.exception.NonImplementedException;
import be.winecave.model.Bouteille;
import be.winecave.model.Categorie;
import be.winecave.model.Classement;
import be.winecave.model.Conservation;
import be.winecave.model.Couleur;
import be.winecave.model.Region;
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
		//TODO check if special categrori "vin de pays , vin de table " user can add specific region but only land
		if(vin == null){
			throw new IllegalArgumentException("le paramètre vin ne peut pas être null");
		}
		//un vin doit avoir au minimum un nom donc on regarde si le nom n'est pas null ou vide
		if(vin.getNom() == null || vin.getNom().isEmpty()){
			throw new IllegalArgumentException("le nom du vin ne doit pas être vide");//TODO créer une exception pour els champs empty ? --maxime 28/12/12
		}
		
		Region region = regionViticoleRepository.findByName(nomRegion);
		if (region == null) {
			region = paysViticoleRepository.findByName(nomRegion);
		}
		
		Categorie categorie = categorieRepository.findByName(nomCategorie);
		Couleur couleur = couleurRepository.findByName(nomCouleur);
		Bouteille bouteille = bouteilleRepository.findByName(nomBouteille);
		Classement classement = classementRepository.findByName(nomClassement);
		
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		
		//TODO chercher dans la db une conservation qui correspondrait en tout point à celle donnée
		Conservation conservation = null;
		try {
			conservation = new Conservation(yearFormat.parse(anneeMinimumConservation), yearFormat.parse(anneeMaximumConservation), yearFormat.parse(anneeDebutApogee), yearFormat.parse(anneeFinApogee), temperatureMinimum, temperatureMaximum);
		} catch (ParseException e) {
			throw new IllegalArgumentException("la date de conservation du vin est dans un mauvais format");
		}
		
		Vin result = vin;
		
		result.setRegion(region);
		result.setCategorie(categorie);
		result.setCouleur(couleur);
		result.setBouteille(bouteille);
		result.setClassement(classement);
		result.setConservation(conservation);
		
		conservationRepository.persist(conservation);
		vinRepository.persist(vin);
		
		return result;
	}
	
	//TODO methode qui supprime le vin car le vin est lié à beacoup d'entités donc supprimé , ou pas , les entités liées
	void supprimerVin() {
		throw new NonImplementedException("supprimerVin()");
	}
}
