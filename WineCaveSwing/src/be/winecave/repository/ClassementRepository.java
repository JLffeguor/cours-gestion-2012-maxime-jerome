package be.winecave.repository;

import org.springframework.stereotype.Repository;

import be.winecave.model.Classement;
@Repository
public class ClassementRepository extends BaseRepository<Classement> {

	public Classement findByName(String nomClassement) {
		return getSingleOrNullResult(em.createQuery("select c from Classement c where c.nom=:nom").setParameter("nom", nomClassement));
	}

}
