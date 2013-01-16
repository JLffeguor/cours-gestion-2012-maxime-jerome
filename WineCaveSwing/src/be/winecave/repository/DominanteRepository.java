package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Categorie;
import be.winecave.model.Dominante;


@Repository
@SuppressWarnings("unchecked")
public class DominanteRepository extends BaseRepository<Dominante> {
	
	public Dominante findByName(String nomDominante) {
		return getSingleOrNullResult(em.createQuery("select d from Dominante d where d.nom_dominante=:nom").setParameter("nom",nomDominante));
	}


	public List<Dominante> findAll() {
		return em.createQuery("select d from Dominante d order by d.nom_dominante").getResultList();
	}

}
