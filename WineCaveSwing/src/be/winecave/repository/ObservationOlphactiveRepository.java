package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Categorie;
import be.winecave.model.ObservationOlphactive;


@Repository
@SuppressWarnings("unchecked")
public class ObservationOlphactiveRepository extends BaseRepository<ObservationOlphactive>{

	public List<ObservationOlphactive> findAll() {
		return em.createQuery("select c from ObservationOlphactive c").getResultList();
	}
}
