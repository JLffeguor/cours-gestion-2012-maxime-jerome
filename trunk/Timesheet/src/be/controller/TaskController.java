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
import be.repository.UserRepository;
import be.security.SecurityContext;
import be.service.TaskService;
import be.util.NotificationUtil;


@Controller
public class TaskController extends BaseController<User> {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	TaskService taskService;
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/task_add")
	public ModelAndView userAdd(@RequestParam("projectId") long projectId) {
		try {
			SecurityContext.assertUserIsLoggedIn();
		} catch (UnauthorizedAccessException uae) {
			return new ModelAndView("redirect:login");
		}
		
		ModelAndView mv = new ModelAndView("task_add","projectId",projectId);

		return mv;
	}
	
	@RequestMapping("/task_submit")
	public String projectSubmit(@RequestParam("projectId") long projectId,
								@RequestParam("plannedHours") double plannedHours,
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

    @RequestMapping("/task_suspend")
    public String projectActivity(@RequestParam("taskId") long taskId,
    		@RequestParam("projectId") long projectId) {
		try {
			taskService.suspendTask(taskId);
		} catch (Exception e) {
			NotificationUtil.addErrorMessage(e.getMessage());
			return "redirect:project?projectId="+projectId;
		}
		
		NotificationUtil.addNotificationMessage("la modification d'état à été correctement effectuée");
		
    	return "redirect:project?projectId="+projectId;
    }   
   
}
