package be.winecave.security;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import be.winecave.exception.UnauthorizedAccessException;
import be.winecave.model.User;

/**
 * Holds the security related information during request execution.
 * only for compatability with class bring from RYC
 * use only for local software
 */
public  class SecurityContext {

	private static User user;
	/**
     * Removes the security context associated to the request
     */
    public static void clear() {
        user = null;
    }

    public static void assertUserIsLoggedIn() {
        if (getUser() == null) {
            throw new UnauthorizedAccessException();
        }
    }

    public static User getUser()  {
       
        return user;
    }


    private static  void setUser(User userParam) {
        //Security constraint
        if (user != null) {
            throw new IllegalStateException("Bug: Could not set a new user on the security context once a user has already been set");
        }

        user = userParam;
    } 

    //method to know if the user is logged or not
    public static boolean isUserLoggedIn() {
		return user != null;
    }

}
