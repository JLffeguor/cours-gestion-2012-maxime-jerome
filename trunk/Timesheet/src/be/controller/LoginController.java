package be.controller;



import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import be.exception.InvalidPasswordException;
import be.exception.UserNotFoundException;
import be.model.User;
import be.repository.UserRepository;
import be.service.LoginService;



@Controller
public class LoginController extends BaseController<User> {

	@Autowired LoginService loginService;
    @Autowired UserRepository userRepository;
    
    @RequestMapping("/login")
    public String loginPage() {
		return "login";
    }
    
    /**
     * 
     * @param password required=false because we don't use pswd in DEV
     * @param keepLoggedIn required=false because when user don't check the checkbox we get a 400 error
     * @return 
     * @return
     */
    @RequestMapping("/loginsubmit")
    public ModelAndView loginSubmit(@RequestParam("identifier") String userNameOrMail,
    		@RequestParam(value="password",required=false) String password,
    		WebRequest request) {
    	String errorMsg = null;
    	User user = null;
    	
    	loginService.logout();//to avoid two login at one time problem
    	
    	try {
    		user = loginService.login(userNameOrMail, password, null);

    	} catch (UserNotFoundException e) {
    		errorMsg="L'utilisateur '"+userNameOrMail+"' n'existe pas";

    	} catch (InvalidPasswordException e) {

    		try {
    			User retrieveuser = loginService.identifyUserByEMailOrName(userNameOrMail) ;

    		} catch (UserNotFoundException e1) {
    			errorMsg="L'utilisateur '"+userNameOrMail+"' n'existe pas";
    		}

    		if (StringUtils.isBlank(errorMsg)){
    			errorMsg="Ce mot de passe n'est pas valide pour l'utilisateur '"+userNameOrMail+"'";
    		}

    	}


    	if (errorMsg != null) {
    		ModelAndView mv = new ModelAndView("redirect:login");
    		return mv;
    	} else {
    		return new ModelAndView("redirect:dashboard");
    	}
    }
    
   
}
