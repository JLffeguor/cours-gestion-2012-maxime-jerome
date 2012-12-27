package be.winecave.repository;

import org.springframework.stereotype.Repository;

import be.winecave.model.Categorie;
@Repository
public class CategorieRepository extends BaseRepository<Categorie> {

	public Categorie findByName(String nomCategorie) {
		return getSingleOrNullResult(em.createQuery("select c from Categorie c where c.nom=:nom").setParameter("nom",nomCategorie));
	}

}
