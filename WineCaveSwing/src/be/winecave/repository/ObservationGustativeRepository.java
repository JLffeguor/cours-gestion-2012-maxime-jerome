package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Categorie;
import be.winecave.model.ObservationGustative;


@Repository
@SuppressWarnings("unchecked")
public class ObservationGustativeRepository extends BaseRepository<ObservationGustative>{

	public List<ObservationGustative> findAll() {
		return em.createQuery("select c from ObservationGustative c ").getResultList();
	}
}
