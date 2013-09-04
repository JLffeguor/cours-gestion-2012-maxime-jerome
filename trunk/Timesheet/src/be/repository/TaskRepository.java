package be.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import be.model.AbstractTask;
import be.model.Task;
import be.security.SecurityContext;

@Repository
public class TaskRepository extends BaseRepository<Task> {
	
	
	public List<Task> getAllTaskAssignedTocurrentUSer() {
		List<Task> result = new ArrayList<>();
		
		for(AbstractTask task : findAll() ) {
			if( task instanceof Task && task.getAssignedUsers().containsKey(SecurityContext.getUser())) {
				result.add((Task) task);
			}
		}
		
		return result;
	}
	
    @SuppressWarnings("unchecked")
	public List<Task> findAll(){
        return  em.createQuery("select t from Task t").getResultList();
    }

}
