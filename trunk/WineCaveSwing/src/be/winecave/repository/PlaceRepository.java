package be.winecave.repository;

import org.springframework.stereotype.Repository;

import be.winecave.model.Emplacement;
import be.winecave.model.Place;

@Repository
public class PlaceRepository extends BaseRepository<Place>{

	public Place findExactPlace(Emplacement emplacement, int x , int y){
		return getSingleOrNullResult(em.createQuery("select p Place p where p.emplacement=:emplacement and p.x=:x and p.y=:y")
									 .setParameter("emplacement", emplacement)
									 .setParameter("x", x)
									 .setParameter("y", y));
	}
}
