package be.web;

import org.springframework.stereotype.Component;

import be.model.User;
import be.security.SecurityContext;

/** An instance of Current will be bound to the servletContext, in order to enable JSPs to refer it through EL.
 * For example: ${current.user.firstName}
 * 
 * We could have stored a User instance in the HttpSession, but it would be an "old detached" instance. 
 * If the user changes its firstName, for example, that HttpSession User instance would not have been refreshed automatically.
 * => we have this mechanism.
 */
@Component
public class Current {

    public static final String ATTRIBUTE_KEY = "current";  

    
    public User getUser(){
        return SecurityContext.getUser();
    }
         

}
