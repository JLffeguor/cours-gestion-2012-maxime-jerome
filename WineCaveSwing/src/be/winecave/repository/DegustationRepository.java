package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Degustation;


@Repository
@SuppressWarnings("unchecked")
public class DegustationRepository extends BaseRepository<Degustation>{

	public List<Degustation> findAll() {
		return em.createQuery("select c from Categorie c order by c.nom").getResultList();
	}
}
