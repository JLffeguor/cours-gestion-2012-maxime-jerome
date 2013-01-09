package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.Vin;
@Repository
public class VinRepository extends BaseRepository<Vin> {
	
	public List<String> findAllProducteur() {
		return em.createQuery("select producteur from Vin v order by v.producteur").getResultList();
	}

}
