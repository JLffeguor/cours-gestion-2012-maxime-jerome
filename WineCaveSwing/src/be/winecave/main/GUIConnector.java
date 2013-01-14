package be.winecave.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.model.Vin;
import be.winecave.repository.BouteilleRepository;
import be.winecave.repository.CategorieRepository;
import be.winecave.repository.ClassementRepository;
import be.winecave.repository.CouleurRepository;
import be.winecave.repository.EmplacementRepository;
import be.winecave.repository.PaysViticoleRepository;
import be.winecave.repository.RegionViticoleRepository;
import be.winecave.repository.VinRepository;
import be.winecave.service.VinService;
/**
 * because gui classes aren't spring bean we need to have an util class who manage spring bean 
 *
 */
@Component
@Lazy
@Scope("singleton")
public class GUIConnector {
	
	private Vin currentVin;

	public Vin getCurrentVin() {
		if (currentVin == null) {
			throw new RuntimeException("currentVin is null");
		}
		return currentVin;
	}

	public void setCurrentVin(Vin currentVin) {
		this.currentVin = currentVin;
	}

	@Autowired
	VinService vinService;
	
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
	@Autowired
	VinRepository vinRepository;
	@Autowired
	EmplacementRepository emplacementRepository;
	
	
	public EmplacementRepository getEmplacementRepository() {
		return emplacementRepository;
	}
	public VinService getVinService() {
		return vinService;
	}
	public RegionViticoleRepository getRegionViticoleRepository() {
		return regionViticoleRepository;
	}
	public PaysViticoleRepository getPaysViticoleRepository() {
		return paysViticoleRepository;
	}
	public CategorieRepository getCategorieRepository() {
		return categorieRepository;
	}
	public CouleurRepository getCouleurRepository() {
		return couleurRepository;
	}
	public BouteilleRepository getBouteilleRepository() {
		return bouteilleRepository;
	}
	public ClassementRepository getClassementRepository() {
		return classementRepository;
	}
	public VinRepository getVinRepository() {
		return vinRepository;
	}
}
