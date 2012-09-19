package service;

import Repository.UserRepository;
import model.Users;

public class UserService {
	
	UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public Users registerUser(String adress, int childrenNumber, String matricule, int phone){
		//TODO search of an already registered user
		
		Users newUser = new Users();
		
		newUser.setAdress(adress);
		newUser.setChildrenNumber(childrenNumber);
		newUser.setMatricule(matricule);
		newUser.setPhone(phone);
		
		userRepository.persist(newUser);
		return newUser;
	}

}
