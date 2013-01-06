package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.PaysViticole;

@Repository
@SuppressWarnings("unchecked")
public class PaysViticoleRepository extends BaseRepository<PaysViticole>{

	public PaysViticole findByName(String name) {
		return getSingleOrNullResult(em.createQuery("select p from PaysViticole p where p.nom=:nom").setParameter("nom", name));
	}
	
	
	public List<PaysViticole> findAll() {
		return em.createQuery("select p from PaysViticole p order by p.nom").getResultList();
	}
}
