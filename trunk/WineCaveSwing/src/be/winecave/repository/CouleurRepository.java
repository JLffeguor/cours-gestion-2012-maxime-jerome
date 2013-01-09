package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Couleur;
@Repository
public class CouleurRepository extends BaseRepository<Couleur> {

	public Couleur findByName(String nomCouleur) {
		return getSingleOrNullResult(em.createQuery("select c from Couleur c where c.nom=:nom").setParameter("nom", nomCouleur));
	}

	public List<Couleur> findAll() {
		return em.createQuery("select c from Couleur c order by c.nom").getResultList();
	}

}
