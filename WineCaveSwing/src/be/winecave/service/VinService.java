package be.winecave.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import be.winecave.repository.CouleurRepository;
import be.winecave.repository.PaysViticoleRepository;
import be.winecave.repository.RegionViticoleRepository;

@Service
public class VinService {
	@Autowired
	RegionViticoleRepository regionViticoleRepository;
	@Autowired
	PaysViticoleRepository paysViticoleRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	CouleurRepository couleurRepository;
	@Autowired
	BouteilleRepository bouteilleRepository;
	@Autowired
	ClassementRepository classementRepository;

	public Vin creerVin(String nomRegion,
						String nomCategorie,
						String nomCouleur,
						String nomBouteille,
						String nomClassement,
						Date minimumConservation,Date maximumConservation,Date debutApogee,Date finApogee,double temperature,
			Vin vin) throws Exception {
		//TODO assert user can do this
		//TODO check if special categrori "vin de pays , vin de table " user can add specific region but only land
		if(vin == null){
			throw new IllegalArgumentException("le nom ne doit pas être vide");//TODO créer une exception pour els champs empty ? --maxime 28/12/12
		}
		//un vin doit avoir au minimum un nom donc on regarde si le nom n'est pas null ou vide
		if(vin.getNom() == null || vin.getNom().isEmpty()){
			throw new Exception("le nom ne doit pas être vide");//TODO créer une exception pour els champs empty ? --maxime 28/12/12
		}
		
		Region region = regionViticoleRepository.findByName(nomRegion);
		if (region == null) {
			region = paysViticoleRepository.findByName(nomRegion);
		}
		
		Categorie categorie = categorieRepository.findByName(nomCategorie);
		Couleur couleur = couleurRepository.findByName(nomCouleur);
		Bouteille bouteille = bouteilleRepository.findByName(nomBouteille);
		Classement classement = classementRepository.findByName(nomClassement);
		
		//TODO chercher dans la db une conservation qui correspondrait en tout point à celle donnée
		Conservation conservation = new Conservation(minimumConservation, maximumConservation, debutApogee, finApogee, temperature);
		
		Vin result = new Vin();
		
		result.setRegion(region);
		result.setCategorie(categorie);
		result.setCouleur(couleur);
		result.setBouteille(bouteille);
		result.setClassement(classement);
		result.setConservation(conservation);
		
		return result;
	}
}
