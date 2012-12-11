package be.winecave.exception;

import be.winecave.security.SecurityContext;

/**
 * bring form RYC and adapt to local
 * @author maxime
 *
 */
@SuppressWarnings("serial")
public class UnauthorizedAccessException extends RuntimeException {

    public UnauthorizedAccessException() {
        super();
    }

    private static String getCurrentUserString() {
        if (SecurityContext.getUser() != null) {
            return "Current user " +  SecurityContext.getUser().getFullName() + ", ";  
        } else {
            return "Unconnected visitor, ";  
        }
    }

    public UnauthorizedAccessException(String message) {
        super(getCurrentUserString() + message);
    }

    public UnauthorizedAccessException(String message, Throwable root) {
        super(getCurrentUserString() + message, root);
    }

}