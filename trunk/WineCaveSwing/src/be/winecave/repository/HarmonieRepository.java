package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Harmonie;

@Repository
@SuppressWarnings("unchecked")
public class HarmonieRepository extends BaseRepository<Harmonie>{
	

	public Harmonie findByName(String nom_harmonie) {
		return getSingleOrNullResult(em.createQuery("select c from Harmonie c where c.nom=:nom_harmonie").setParameter("nom",nom_harmonie));
	}
	public List<Harmonie> findAll() {
		return em.createQuery("select c from Harmonie c order by c.nom_harmonie").getResultList();
	}
}
