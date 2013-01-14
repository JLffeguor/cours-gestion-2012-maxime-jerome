package be.winecave.repository;

import org.springframework.stereotype.Repository;

import be.winecave.model.Emplacement;
@Repository
public class EmplacementRepository extends BaseRepository<Emplacement> {
	
	public Emplacement findByName(Object nom) {
		return getSingleOrNullResult(em.createQuery("select e from Emplacement e where e.nom=:nom")
				.setParameter("nom", nom));
	}

}
