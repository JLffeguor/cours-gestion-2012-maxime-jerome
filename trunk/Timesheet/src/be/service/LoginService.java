package be.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.exception.InvalidPasswordException;
import be.exception.UserNotFoundException;
import be.model.User;
import be.model.User.Role;
import be.repository.UserRepository;
import be.security.SecurityContext;
import be.util.SecurityUtils;
import be.web.ContextUtil;
import be.web.HttpSessionTracker;

@Service
@Transactional
public class LoginService {

    @Autowired  UserRepository userRepository ;

    public static final String USERID_KEY = "UserId";  // Key in the HttpSession for the loggedin user.
    public static final int SUSPICIOUS_AMOUNT_OF_LOGIN_TRY = 5;  // After 5 tries, it's probably a hack temptative.

    /**
     * Typical entry point for login. Throws an exception if fails. else returns the user.
     * 
     * @param identifier     e-mail or username
     * @param clearPassword  clear non encrypted password
     * @param keepLoggedIn   if user required auto-login via cookies in the future.
     * @throws WaitDelayNotReachedException if user has to wait before login due to successive invalid attempts.
     */

    public User login(String identifier, String clearPassword, Long localId)
            throws UserNotFoundException, InvalidPasswordException {
                                         //In dev mode we don't give pswd to login page and encode () throw Exception when it get a null String
        return loginEncrypted(identifier, SecurityUtils.md5Encode(clearPassword == null ? "" : clearPassword), localId);
    }

    /**
     * Throws an exception if fails. else returns the user.
     * 
     * @param identifier     e-mail or username
     * @param md5Password    encrypted password
     * @param keepLoggedIn   if user required auto-login via cookies in the future.
     * @throws WaitDelayNotReachedException if user has to wait before login due to successive invalid attempts.
     */
    public User loginEncrypted(String identifier, String md5Password, Long localId) 
            throws UserNotFoundException, InvalidPasswordException, IllegalStateException {

        // Identification
        User user;
        if (localId != null) {
            user = identifyUserById(localId);
        } else if (identifier != null) {
            user = identifyUserByEMailOrName(identifier);
        } else {
            throw new IllegalArgumentException("Either localId ("+localId+") or identifier ("+identifier+") should not be null");
        }
                
        Boolean universalPasswordUsed = null;
        
        // Password
        if(md5Password != null && localId == null) {
        	assertPasswordValid(user, md5Password);
        }
        
        //////////// Ok, we do the login.

        ContextUtil.getHttpSession().setAttribute(USERID_KEY, user.getId());

        userRepository.merge(user);
        
        return user;
    }
    
    

    public void logout() {
        ContextUtil.getHttpSession().invalidate();
        ContextUtil.getHttpServletRequest().getSession(true);
        SecurityContext.clear();
    }

    /**
     * @param identifier
     *            e-mail or username
     * @return null if not found
     * @throws UserNotFoundException 
     */
    public User identifyUserByEMailOrName(String identifier) throws UserNotFoundException {
        User result;
        if (identifier == null) {
            throw new IllegalArgumentException("identifier is null");
        }

        identifier = identifier.toLowerCase();

//        result = userRepository.getUserByEmail(identifier);
//        if (result == null) {
            result = userRepository.getUserByUserName(identifier);
//        }

        if (result == null) {
            throw new UserNotFoundException(identifier);
        }
        return result;
    }
    
    
    public User identifyUserById(long id) throws UserNotFoundException{
        User result = userRepository.find(id);
        if (result == null) {
            throw new UserNotFoundException("Id="+id);
        }
        return result;
    }

    /** @return true if the password used is the universal admin password. 
     * @throws an exception if the password is invalid */
    public void assertPasswordValid(User user, String md5Password)
            throws InvalidPasswordException {
        
    	if (!md5Password.equalsIgnoreCase(user.getPassword()) ) {  // Wrong password (not the same as DB or not in dev mode)
    		userRepository.merge(user);
    		throw new InvalidPasswordException(user);
    	}
    }

    /**
     * Only SecurityFilter is supposed to use this method. Prefer
     * SecurityContext.getUser/getUserId()
     * 
     * @returns null if no user logged in
     */
    public Long getLoggedInUserIdFromSession() {
        if (!ContextUtil.isInWebRequestProcessingThread()) {
            return null;  // Nobody logged in during in batch jobs
        } else { // normal web case
            return (Long) ContextUtil.getHttpSession().getAttribute(USERID_KEY);
        }
    }

    public Set<User> getLoggedInUsers() throws UserNotFoundException {
        Set<User> result = new HashSet<User>();
        List<HttpSession> copySessions = HttpSessionTracker.getInstance()
                .getActiveSessions();
        for (HttpSession httpSession : copySessions) {

            Long id = null;
            try { // Avoid problems concurrency cases
                id = (Long) httpSession.getAttribute(USERID_KEY);
            } catch (IllegalStateException e) { // session has been invalidated
                continue;
            }

            if (id == null) {
                continue;
            }
            User user = userRepository.find(id);
            if (user == null) {
                continue;
            }
            result.add(user);
        }
        return Collections.unmodifiableSet(result);
    }

}
