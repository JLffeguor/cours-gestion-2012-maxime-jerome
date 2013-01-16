package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Finesse;


@Repository
@SuppressWarnings("unchecked")
public class FinesseRepository extends BaseRepository<Finesse>{


	public Finesse findByName(String nom_finesse) {
		return getSingleOrNullResult(em.createQuery("select c from Finesse c where c.nom=:nom_finesse").setParameter("nom",nom_finesse));
	}


	public List<Finesse> findAll() {
		return em.createQuery("select c from Finesse c order by c.nom_finesse").getResultList();
	}

}
