package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Classement;
@Repository
@SuppressWarnings("unchecked")
public class ClassementRepository extends BaseRepository<Classement> {

	public Classement findByName(String nomClassement) {
		return getSingleOrNullResult(em.createQuery("select c from Classement c where c.nom=:nom").setParameter("nom", nomClassement));
	}

	
	public List<Classement> findAll() {
		return em.createQuery("select c from Classement c order by c.nom").getResultList();
	}

}
