package be.controller;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.exception.UnauthorizedAccessException;
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
	public ModelAndView prestationSubmit(@RequestParam("taskId") long taskId,
    							@RequestParam(value="description") String description,
    							@RequestParam(value="start") String start,
    							@RequestParam(value="end") String end) throws ParseException  {
		try {
			SecurityContext.assertUserIsLoggedIn();
		} catch (UnauthorizedAccessException uae) {
			new ModelAndView("redirect:login");
		}

		Date startDate = DateUtils.parseDate(start, "dd/MM/yyyy HH:mm");
		Date endDate = DateUtils.parseDate(end, "dd/MM/yyyy HH:mm");
		
		System.out.println(DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(startDate));
		//FIXME check if prestation doesn't exceed planned hours
		taskService.addPrestation(taskId, description, startDate, endDate);
		
		ModelAndView mv = new ModelAndView("user_activity","taskList",taskRepository.getAllTaskAssignedTocurrentUSer());
		return mv;
	}
    
    @RequestMapping("/prestation_add")
    public ModelAndView projectActivity(@RequestParam("taskId") long taskId) {
		ModelAndView mv = new ModelAndView("prestation_add");
    	mv.addObject("taskId",taskId);
		return mv;
    }   
   
}
