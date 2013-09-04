package be.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.exception.UnauthorizedAccessException;
import be.exception.UserNotFoundException;
import be.model.User;
import be.repository.ProjectRepository;
import be.repository.TaskRepository;
import be.repository.UserRepository;
import be.security.SecurityContext;
import be.service.TaskService;


@Controller
public class PrestationController extends BaseController<User> {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	TaskService taskService;
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/user_activity")
	public ModelAndView userActivity() {
		try {
			SecurityContext.assertUserIsLoggedIn();
		} catch (UnauthorizedAccessException uae) {
			return new ModelAndView("redirect:login");
		}
		
		ModelAndView mv = new ModelAndView("user_activity","taskList",taskRepository.getAllTaskAssignedTocurrentUSer());

		return mv;
	}
	
	@RequestMapping("/prestation_submit")
	public String prestationSubmit(@RequestParam("projectId") long projectId,
								@RequestParam("plannedHours") int plannedHours,
    							@RequestParam(value="description",required=false) String description,
    							@RequestParam(value="userNameList",required=false) String assignedUserUserName) throws UserNotFoundException {
		try {
			SecurityContext.assertUserIsLoggedIn();
		} catch (UnauthorizedAccessException uae) {
			return "redirect:login";
		}
		
		List<String> assignedUser = new ArrayList<>();
		StringTokenizer userName  = new StringTokenizer(assignedUserUserName, ",");
		while (userName.hasMoreElements()) {
			assignedUser.add(StringUtils.trim(userName.nextToken()));
		}
		
		taskService.createTask(projectId, plannedHours, description, assignedUser);
		//TODO check if project is not null
		
		return "redirect:project_manage";
	}
//    
//    @RequestMapping("/project_activity")
//    public String projectActivity() {
//		return "dashboard";
//    }   
   
}
