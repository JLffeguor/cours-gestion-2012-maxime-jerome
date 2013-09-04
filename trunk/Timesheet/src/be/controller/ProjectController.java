package be.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.exception.UnauthorizedAccessException;
import be.model.Project;
import be.model.User;
import be.model.User.Role;
import be.repository.ProjectRepository;
import be.security.SecurityContext;
import be.service.ProjectService;


@Controller
public class ProjectController extends BaseController<User> {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	ProjectService projectService;

    @RequestMapping("/project_manage")
    public ModelAndView projectManage() {
    	ModelAndView mv = new ModelAndView("project_manage");
    	if(SecurityContext.isUserHasRole(Role.PROJECT_ADMIN) 
    		|| SecurityContext.isUserHasRole(Role.ADMIN)) {
    		
    			mv.addObject("projectList", projectRepository.findAll());
    			mv.addObject("canCreateProject", true);
    	
    	} else { //if the user is "only" a projetc manager for some project
    	
    		List<Project> projects = projectRepository.findAll();
    		List<Project> assignedProject = new ArrayList<>();
    		
    		for(Project project : projects) {
    			if(project.getAssignedUsers().containsKey(SecurityContext.getUser()) 
    			   && project.getAssignedUsers().get(SecurityContext.getUser()).equals(Role.PROJECT_MANAGER) ) {
    				assignedProject.add(project);    				
    			}
    		}
    		
    		mv.addObject("projectList", assignedProject);
    		
    	}
    	
    	
		return mv;
    }    
    
	@RequestMapping("/project_add")
	public String userAdd() {
		try {
			SecurityContext.assertUserIsLoggedIn();
		} catch (UnauthorizedAccessException uae) {
			return "redirect:login";
		}

		return "project_add";
	}
	
	@RequestMapping("/project_submit")
	public String projectSubmit(@RequestParam("projectName") String projectName,
    		@RequestParam(value="description",required=false) String description,
    		@RequestParam("projectManagerUserName") String projectManagerUserName,
    		@RequestParam(value="assignedUser",required=false) String[] assignedUserUserName) {
		try {
			SecurityContext.assertUserIsLoggedIn();
		} catch (UnauthorizedAccessException uae) {
			return "redirect:login";
		}
		if(assignedUserUserName == null) {
			assignedUserUserName = new String[0];
		}
		projectService.createProject(projectName, description, projectManagerUserName, Arrays.asList(assignedUserUserName));
		//TODO check if project is not null
		
		return "redirect:project_manage";
	}
	
    @RequestMapping("/project")
    public ModelAndView projectManage(@RequestParam("projectId") Long projectId) {
    	ModelAndView mv = new ModelAndView("project");
    	Project project = projectRepository.find(projectId);
    	
    	if( SecurityContext.canCurrentUserChangeProject(project)) {
    		
    			mv.addObject("project", project);
    			mv.addObject("TaskList", projectRepository.findAllTaskforProjetc(project));
    	
    	}
    	
    	
		return mv;
    } 
    
    @RequestMapping("/project_activity")
    public String projectActivity() {
		return "dashboard";
    }   
   
}
