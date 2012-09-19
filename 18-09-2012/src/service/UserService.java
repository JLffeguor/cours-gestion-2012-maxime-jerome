package service;

import Repository.UserRepository;
import model.Users;

public class UserService {
	
	UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public Users registerUser(Users newUser){
		//TODO search of an already registered user
		userRepository.persist(newUser);
		return newUser;
	}

}
