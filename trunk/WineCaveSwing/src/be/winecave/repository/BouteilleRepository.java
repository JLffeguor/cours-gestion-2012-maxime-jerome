package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Bouteille;
@Repository
@SuppressWarnings("unchecked")
public class BouteilleRepository extends BaseRepository<Bouteille> {

	public Bouteille findByName(String nomBouteille) {
		return getSingleOrNullResult(em.createQuery("select b from Bouteille b where b.nom=:nom").setParameter("nom", nomBouteille));
	}

	public List<Bouteille> findAll() {
		return em.createQuery("select b from Bouteille b order by b.nom").getResultList();
	}

}
