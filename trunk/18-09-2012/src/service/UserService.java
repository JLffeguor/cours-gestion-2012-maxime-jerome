package service;

import Repository.UserRepository;
import model.User;

public class UserService {
	
	UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public User registerUser(String adress, int childrenNumber, String matricule, int phone){
		//TODO search of an already registered user
		
		User newUser = new User();
		
		newUser.setAdress(adress);
		newUser.setChildrenNumber(childrenNumber);
		newUser.setMatricule(matricule);
		newUser.setPhone(phone);
		
		userRepository.persist(newUser);
		return newUser;
	}

}
