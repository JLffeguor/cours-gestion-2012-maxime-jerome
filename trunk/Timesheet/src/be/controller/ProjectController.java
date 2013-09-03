package be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.model.User;
import be.repository.ProjectRepository;


@Controller
public class ProjectController extends BaseController<User> {
	
	@Autowired
	ProjectRepository projectRepository;

    @RequestMapping("/project_manage")
    public ModelAndView projectManage() {
    	ModelAndView mv = new ModelAndView("project_manage");
//    	if(SecurityContext.isUserHasRole(Role.PROJECT_ADMIN) 
//    		|| SecurityContext.isUserHasRole(Role.ADMIN)) {
    			mv.addObject("projectList", projectRepository.findAll());
//    		}
		return mv;
    }    
    
    @RequestMapping("/project_activity")
    public String projectActivity() {
		return "dashboard";
    }   
   
}
