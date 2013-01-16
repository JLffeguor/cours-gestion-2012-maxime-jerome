package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.PuissanceAromatique;

@Repository
@SuppressWarnings("unchecked")
public class PuissanceAromatiqueRepository extends BaseRepository<PuissanceAromatique>{

	public PuissanceAromatique findByName(String nom_Aromatique) {
		return getSingleOrNullResult(em.createQuery("select c from Classement c where c.nom_Aromatique=:nom").setParameter("nom", nom_Aromatique));
	}

	
	public List<PuissanceAromatique> findAll() {
		return em.createQuery("select c from PuissanceAromatique c order by c.PuissanceAromatique").getResultList();
	}
}
