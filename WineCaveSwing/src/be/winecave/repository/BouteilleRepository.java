package be.winecave.repository;

import org.springframework.stereotype.Repository;

import be.winecave.model.Bouteille;
@Repository
public class BouteilleRepository extends BaseRepository<Bouteille> {

	public Bouteille findByName(String nomBouteille) {
		return getSingleOrNullResult(em.createQuery("select b from Bouteille b where b.nom=:nom").setParameter("nom", nomBouteille));
	}

}
