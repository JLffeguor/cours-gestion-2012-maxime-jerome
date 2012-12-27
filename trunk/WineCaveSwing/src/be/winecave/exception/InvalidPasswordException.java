package be.winecave.exception;

import be.winecave.model.User;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {

    private User user;
    
	public InvalidPasswordException(User user) {
		super("Invalid password for user Username=" + user.getFullName()+ " full name = "+user.getFullName());
		this.user=user;
	}
	
}
