package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Carafage;


@Repository
@SuppressWarnings("unchecked")
public class CarafageRepository extends BaseRepository<Carafage> {

	public Carafage findByName(String carafage) {
		return getSingleOrNullResult(em.createQuery("select c from Carafage c where c.type_carafage=:nom").setParameter("nom",carafage));
	}


	public List<Carafage> findAll() {
		return em.createQuery("select c from Carafage c order by c.type_carafage").getResultList();
	}
}
