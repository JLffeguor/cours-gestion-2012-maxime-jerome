package be.winecave.repository;

import org.springframework.stereotype.Repository;

import be.winecave.model.PaysViticole;

@Repository
public class PaysViticoleRepository extends BaseRepository<PaysViticole>{

	public PaysViticole findByName(String name) {
		return getSingleOrNullResult(em.createQuery("select p from PaysViticole p where p.nom=:nom").setParameter("nom", name));
	}
}
