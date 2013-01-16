package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Classement;
import be.winecave.model.ObservationVisuelle;


@Repository
@SuppressWarnings("unchecked")
public class ObservationVisuelleRepository extends BaseRepository<ObservationVisuelle>{

	public List<ObservationVisuelle> findAll() {
		return em.createQuery("select c from Classement c order by c.nom").getResultList();
	}
}
