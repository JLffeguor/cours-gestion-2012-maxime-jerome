package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Matiere;


@Repository
@SuppressWarnings("unchecked")
public class MatiereRepository extends BaseRepository<Matiere>{


	public Matiere findByName(String nom_matiere) {
		return getSingleOrNullResult(em.createQuery("select c from Matiere c where c.nom_matiere=:nom").setParameter("nom",nom_matiere));
	}


	public List<Matiere> findAll() {
		return em.createQuery("select c from Matiere c order by c.nom_matiere").getResultList();
	}

}
