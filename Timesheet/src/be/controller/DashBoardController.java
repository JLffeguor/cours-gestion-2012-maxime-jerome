package be.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import be.model.User;
import be.repository.UserRepository;
import be.service.LoginService;



@Controller
public class DashBoardController extends BaseController<User> {

    @RequestMapping("/dashboard")
    public String loginPage() {
		return "dashboard";
    }    
   
}
