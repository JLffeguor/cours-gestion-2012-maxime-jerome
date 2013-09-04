package be.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import be.model.AbstractTask;
import be.model.Project;
import be.model.Task;

@Repository
public class ProjectRepository extends BaseRepository<Project> {

	@SuppressWarnings("unchecked")
	public List<Project> findAll() {
		return  em.createQuery("select p from Project p").getResultList();
	}

	public List<Task> findAllTaskforProjetc(Project project) {
		List<Task> result = new ArrayList<>();
		for(AbstractTask task : project.getChildren() ) {
			if( task instanceof Task) {
				result.add((Task) task);
			}
		}
		return result;
	}

}
