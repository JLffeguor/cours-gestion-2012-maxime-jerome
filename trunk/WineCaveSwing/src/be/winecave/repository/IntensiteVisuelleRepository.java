package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Categorie;
import be.winecave.model.IntensiteVisuelle;


@Repository
@SuppressWarnings("unchecked")
public class IntensiteVisuelleRepository extends BaseRepository<IntensiteVisuelle> {

	public IntensiteVisuelle findByName(String nomIntensiteVisuelle) {
		return getSingleOrNullResult(em.createQuery("select c from IntensiteVisuelle c where c.nomIntensiteVisuelle=:nom").setParameter("nom",nomIntensiteVisuelle));
	}


	public List<IntensiteVisuelle> findAll() {
		return em.createQuery("select c from IntensiteVisuelle c order by c.nomIntensiteVisuelle").getResultList();
	}

	
}
