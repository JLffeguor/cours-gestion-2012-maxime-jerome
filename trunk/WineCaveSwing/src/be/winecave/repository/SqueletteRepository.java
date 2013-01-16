package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Squelette;


@Repository
@SuppressWarnings("unchecked")
public class SqueletteRepository extends BaseRepository<Squelette>{

	public Squelette findByName(String nomSquelette) {
		return getSingleOrNullResult(em.createQuery("select c from Squelette c where c.nomSquelette=:nom").setParameter("nom", nomSquelette));
	}

	
	public List<Squelette> findAll() {
		return em.createQuery("select c from Squelette c order by c.nomSquelette").getResultList();
	}
}
