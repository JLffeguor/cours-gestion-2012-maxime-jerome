package be.winecave.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.winecave.model.QualiteEnsemble;

@Repository
@SuppressWarnings("unchecked")
public class QualiteEnsembleRepository extends BaseRepository<QualiteEnsemble>{
	
	public List<QualiteEnsemble> findAll() {
		return em.createQuery("select c from QualiteEnsemble c ").getResultList();
	}

}
