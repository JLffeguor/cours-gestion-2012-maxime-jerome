package be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import be.model.User;


@Controller
public class ProjectController extends BaseController<User> {

    @RequestMapping("/project_manage")
    public String projectManage() {
		return "project_manage";
    }    
    
    @RequestMapping("/project_activity")
    public String projectActivity() {
		return "dashboard";
    }   
   
}
