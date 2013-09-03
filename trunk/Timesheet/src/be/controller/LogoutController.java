package be.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import be.model.User;
import be.service.LoginService;


@Controller
public class LogoutController extends BaseController<User>{
    
    @Autowired LoginService loginService;

    @RequestMapping("/logout")
    public String logout(WebRequest request) {
  
         loginService.logout();
         
        return "redirect:/";
    }
   
}
