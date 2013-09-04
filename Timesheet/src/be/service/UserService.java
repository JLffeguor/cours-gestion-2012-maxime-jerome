package be.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;

import be.exception.UserAlreadyExistsException;
import be.exception.UserAlreadyExistsException.IdentifierType;
import be.model.User;
import be.repository.UserRepository;
import be.util.SecurityUtils;


@Transactional
@Service(value="userService")
@Scope("singleton")
public class UserService {

    @Autowired   private UserRepository userRepository;
    @Autowired   private LoginService loginService;

    /**
     * Register a user and sends a validation mail.
     * 
     * @param directValidation
     *            : validate an account directly without send a mail
     */
    public User registerUser(String username, String passwordInClear) throws UserAlreadyExistsException {
    	
        if (userRepository.getUserByUserName(username) != null)    {
            throw new UserAlreadyExistsException(IdentifierType.USERNAME, username);
        }
       
        User newUser = new User();
        newUser.setUserName(username);
        newUser.setPassword(SecurityUtils.md5Encode(passwordInClear));
        
        //// Save the user in the db
        userRepository.persist(newUser);

        return newUser;
    }


    /** Change the name of the user and note it in the log */
    public void changeUserName(User user, String newUserName) {
        user.setUserName(newUserName);
        userRepository.merge(user);
    }


    public List<User> getUserLstWithRoleOrPrivilege(){
    	List<User> list1 = userRepository.getUserWithRoleNotNull();
    	List<User> list2 = userRepository.getUserWithPrivilegeNotEmpty();
    	
    	// Add to list1, the users of list2 which are not already in list1.
    	for(User u : list2){
    		if(!(list1.contains(u))){
    			list1.add(u);
    		}
    	}
		return list1;
    }
    
    
	/** Encoding user's nickname and registration date to have a parameter sent to a page.
	 * Used in urls (from mails, for example), to directly authentify a user. */
    public String getUserSecurityString(User user){
		return SecurityUtils.md5Encode(user.getUserName()+user.getCreatedOn().toString()).substring(0, 6);
    }
	
}