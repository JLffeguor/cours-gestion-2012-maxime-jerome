package be.security;
import java.util.Collections;
import java.util.EnumSet;

import be.exception.UnauthorizedAccessException;
import be.model.Prestation;
import be.model.Project;
import be.model.Task;
import be.model.User;
import be.model.User.Role;
import be.repository.UserRepository;
import be.service.LoginService;
import be.web.ContextUtil;



/**
 * Holds the security related information during request execution.
 */

public  class SecurityContext {

    public static final Privilege MASTER_PRIVILEGE = Privilege.MANAGE_USERS;

    private static ThreadLocal<User> user = new ThreadLocal<User>();    // Lazyly retrieved from the DB if needed (if getUser() is called).
    private static ThreadLocal<Long> userId = new ThreadLocal<Long>();  // retrieved in from the session. Non null <=> user logged in.

    /**
     * Removes the security context associated to the request
     */
    public static void clear() {
        user.set(null);
        userId.set(null);
    }

    public static void assertUserHasPrivilege(Privilege privilege) {
        if (!isUserHasPrivilege(privilege)) {
            throw new UnauthorizedAccessException(privilege);
        }
    }

    public static void assertUserIsLoggedIn() {
        if (getUser() == null) {
            throw new UnauthorizedAccessException();
        } 
        System.out.println("user" + getUser().getUserName() + "loggé");
    }


    // Probably the most used method of this class (from outside).
    public static  boolean isUserHasPrivilege(Privilege privilege) {
        return isUserHasAllPrivileges(EnumSet.of(privilege));
    }


    public static  boolean isUserHasAllPrivileges(EnumSet<Privilege> privileges)  {
        if (getUser() == null) {
            return false;
        }
        EnumSet<Privilege> currentPrivileges = getAllAssociatedPrivileges(getUser());
       return currentPrivileges.containsAll(privileges);
    }
    

    /**
     * @return true if the user has one of the privileges
     */
    public static boolean isUserHasOneOfPrivileges(EnumSet<Privilege> privileges) {
        if (getUser() == null) {
            return false;
        }
        if (Collections.disjoint(getAllAssociatedPrivileges(getUser()), privileges) == false) {  // There is at least one element in common.
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return All privilege associated to a community role
     */
    public static EnumSet<Privilege> getAssociatedPrivilege(Role role) {
        EnumSet<Privilege> associatedPrivileges = EnumSet.noneOf(Privilege.class);
        if (role != null) {
            for (Privilege privilege : Privilege.values()) {
            	associatedPrivileges.add(privilege);
            }
        }
        return associatedPrivileges;
    }

    /**
     * @return all the privilege associated to the given user including
     *         associations present in the DB and association derived from
     *         user's role.
     */
    public static EnumSet<Privilege> getAllAssociatedPrivileges(User user) {
        EnumSet<Privilege> allUserPrivileges = EnumSet.noneOf(Privilege.class);
        if (user != null) {
              
            allUserPrivileges.addAll(user.getPrivileges());
           
            allUserPrivileges.addAll(getAssociatedPrivilege(user.getRole()));
        }
        return allUserPrivileges;
    }


    public static User getUser()  {
       
        if (getUserId() == null) {  // Not logged in.
            return null;
        }
        
        if (user.get() == null) {  // User not loaded yet.
            User user = ((UserRepository) ContextUtil.getSpringBean("userRepository")).find(getUserId());
            

            setUser( user );  // Lazy loading if needed.
        }

        return user.get();
    }


    private static  void setUser(User userParam) {
        //Security constraint
        if (user.get() != null) {
            throw new IllegalStateException("Bug: Could not set a new user on the security context once a user has already been set");
        }
        if (userId.get() == null) {
            userId.set(userParam.getId());
        }
        user.set(userParam);
    } 

    //method to know if the user is logged or not
    public static boolean isUserLoggedIn() {
		return getUserId() != null;
    }


    //get the value of the threadlocal userId 
    public static  Long getUserId() {

       if (userId.get() == null) { // Then try to get it from the HttpSession.

            LoginService loginService = (LoginService) ContextUtil.getSpringBean("loginService");              // This is not beauty, but life is sometimes ugly. -- no better idea (except making SecurityContext a bean managed by Spring... but for not much benefit...) -- John 2009-07-02

           Long id = loginService.getLoggedInUserIdFromSession();  
 
           if (id != null) {  // A user is effectively logged in.
                userId.set(id);  // remember it in the SecurityContext.
           }
        }
       
        return userId.get();
    }
 

    public static boolean isUserHasRole(Role role) {
        User user = getUser();
        if(user == null || user.getRole() == null){
            return false;
        } 
        return user.getRole() == role;
    }

    public static void assertUserHasRole(Role role) {
        if (!isUserHasRole(role)) {
               throw new UnauthorizedAccessException("You need the following role: " + role);
           }
   }

    
    //////////////////////////////////////////////////// Specific rights /////////////////////////////////////
    //////////////////////////////////////////////////// Specific rights /////////////////////////////////////
    //////////////////////////////////////////////////// Specific rights /////////////////////////////////////
    //////////////////////////////////////////////////// Specific rights /////////////////////////////////////
    //////////////////////////////////////////////////// Specific rights /////////////////////////////////////

    ////user management
    public static boolean canCurrentUserChangeUser(User userParam) { 
        return userParam.equals(getUser()) // If the user is editing himself
                || isUserHasPrivilege(Privilege.MANAGE_USERS);     // or If this user has the privilege to edit other users

    }

    public static  void assertCurrentUserMayEditThisUser(User userParam) {
        if (! canCurrentUserChangeUser(userParam)) {
            throw new UnauthorizedAccessException(" cannot edit that user: " + userParam.getUserName());
        }
    }
    
    ////project management
    public static boolean canCurrentUserChangeProject(Project projectParam) {
        return projectParam.getAssignedUsers().containsKey(getUser()) && isUserHasPrivilege(Privilege.MANAGE_CURRENT_PROJECT) // If the user is editing himself
                || isUserHasPrivilege(Privilege.MANAGE_PROJECT);     // or If this user has the privilege to edit other users

    }
    public static  void assertCurrentUserMayEditThisProject(Project projectParam) {
        if (! canCurrentUserChangeProject(projectParam)) {
            throw new UnauthorizedAccessException(" cannot edit that project: " + projectParam.getName());
        }
    }
    
    public static boolean canCurrentUserChangeTask(Task taskParam) { 
        return taskParam.getAssignedUsers().containsKey(getUser())
                || isUserHasPrivilege(Privilege.MANAGE_PROJECT);     // or If this user has the privilege to edit other users

    }
    public static  void assertCurrentUserMayEditThisTask(Task taskParam) {
        if (! canCurrentUserChangeTask(taskParam)) {
            throw new UnauthorizedAccessException(" cannot edit that user: " + taskParam.getDescription());
        }
    }
    
    public static boolean canCurrentUserChangePrestation(Prestation prestationParam) { 
        return prestationParam.getAssignedUsers().containsKey(getUser())
                || isUserHasPrivilege(Privilege.MANAGE_PROJECT);     // or If this user has the privilege to edit other users

    }
    public static  void assertCurrentUserMayEditThisPrestation(Prestation prestationParam) {
        if (! canCurrentUserChangePrestation(prestationParam)) {
            throw new UnauthorizedAccessException(" cannot edit that user: " + prestationParam.getDescription());
        }
    }
}
