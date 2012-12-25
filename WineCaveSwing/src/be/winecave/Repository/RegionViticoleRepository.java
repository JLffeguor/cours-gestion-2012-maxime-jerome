package be.winecave.Repository;

import org.springframework.stereotype.Repository;

import be.winecave.model.RegionViticole;
@Repository
public class RegionViticoleRepository extends BaseRepository<RegionViticole> {
	
	public RegionViticole findByName(String name) {
		return getSingleOrNullResult(em.createQuery("select rv from RegionViticole rv where rv.nom=:nom").setParameter("nom", name));
	}
}
