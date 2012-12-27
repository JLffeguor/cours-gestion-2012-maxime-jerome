package be.winecave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.winecave.exception.NullObjectException;
import be.winecave.model.Bouteille;
import be.winecave.model.Categorie;
import be.winecave.model.Classement;
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

	public Vin creerVin(String nomRegion,String nomCategorie,String nomCouleur,String nomBouteille,String nomClassement,
			String millesime,String nom,String producteur,double degre,int note,String cuvee,String cepage,String commentaire) {
		//TODO assert user can do this
		
		Region region = regionViticoleRepository.findByName(nomRegion);
		if (region == null) {
			region = paysViticoleRepository.findByName(nomRegion);
		}
		assertNoTNull(region, Region.class);
		
		Categorie categorie = categorieRepository.findByName(nomCategorie);
		assertNoTNull(categorie, Categorie.class);
		
		Couleur couleur = couleurRepository.findByName(nomCouleur);
		assertNoTNull(couleur, Couleur.class);
		
		Bouteille bouteille = bouteilleRepository.findByName(nomBouteille);
		assertNoTNull(bouteille, Bouteille.class);
		
		Classement classement = classementRepository.findByName(nomClassement);
		assertNoTNull(classement, Classement.class);
		
		Vin result = new Vin();
		
		result.setRegion(region);
		result.setCategorie(categorie);
		result.setCouleur(couleur);
		result.setBouteille(bouteille);
		result.setClassement(classement);
		
		result.setMillesime(millesime);
		result.setNom(nom);
		result.setProducteur(producteur);
		result.setDegre(degre);
		result.setNote(note);
		result.setCuvee(cuvee);
		result.setCepage(cepage);
		result.setCommentaire(commentaire);
		
		return result;
	}
	
	//TODO move to an util class
	public void assertNoTNull(Object object,Class<?> clazz) {
		if(object == null) {
			throw new NullObjectException("this " + clazz.getSimpleName() + " object cannot be null");
		}
	}
}
