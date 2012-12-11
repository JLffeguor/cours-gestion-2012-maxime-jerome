package be.winecave.security;

/**
 * 
 * the purpose of this class is to get the instance of SecurityContext from BaseEntity class where
 *  Autowired does not work properly with spring
 */
public class SecurityContextUtil {
    
    static SecurityContext securityContext ;
    
    
    public SecurityContextUtil(){
        
    }
    
    public static SecurityContext getSecurityContext(){
        
        return securityContext;
    }
    
    public static void setSecurityContextUtil(SecurityContext ctx){
        
        securityContext = ctx;
    }

}
