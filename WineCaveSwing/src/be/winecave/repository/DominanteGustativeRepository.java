package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.DominanteGustative;

@Repository
@SuppressWarnings("unchecked")
public class DominanteGustativeRepository extends BaseRepository<DominanteGustative>{
	

	public DominanteGustative findByName(String nomDominanteGustative) {
		return getSingleOrNullResult(em.createQuery("select c from DominanteGustative c where c.nomDominanteGustative=:nom").setParameter("nom",nomDominanteGustative));
	}


	public List<DominanteGustative> findAll() {
		return em.createQuery("select c from DominanteGustative c order by c.nomDominanteGustative").getResultList();
	}


}
