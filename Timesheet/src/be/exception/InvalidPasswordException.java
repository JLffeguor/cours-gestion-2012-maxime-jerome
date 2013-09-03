package be.exception;

import be.model.User;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {

    private User user;
    
	public InvalidPasswordException(User user) {
		super("Invalid password for user Username=" + user.getUserName());
		this.user=user;
	}
	
}
