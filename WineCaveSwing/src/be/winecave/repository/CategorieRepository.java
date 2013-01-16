package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Categorie;
@Repository
@SuppressWarnings("unchecked")
public class CategorieRepository extends BaseRepository<Categorie> {

	public Categorie findByName(String nomCategorie) {
		return getSingleOrNullResult(em.createQuery("select c from Categorie c where c.nom_dominante=:nom").setParameter("nom",nomCategorie));
	}


	public List<Categorie> findAll() {
		return em.createQuery("select c from Categorie c order by c.nom_dominante").getResultList();
	}

}
