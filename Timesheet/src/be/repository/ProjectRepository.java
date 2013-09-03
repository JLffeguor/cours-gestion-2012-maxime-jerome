package be.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import be.model.Project;

@Repository
public class ProjectRepository extends BaseRepository<Project> {

	@SuppressWarnings("unchecked")
	public List<Project> findAll() {
		return  em.createQuery("select p from Project p").getResultList();
	}

}
