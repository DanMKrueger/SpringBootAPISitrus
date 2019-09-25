package com.sitrus.signup.service;



import org.springframework.stereotype.Service;

import com.sitrus.user.model.User;

@Service 
public class SignUpService {
	
	//create
	public User addUser(String username, String userPassword, String firstName, String lastName, String email, String zip,
			String userType) {
		
		User user = new User(username, userPassword, firstName, lastName, email, zip, userType);
		return user;
		
		}
	
	//read
	
	public User getUser(int id) {
		
		User user = null;
		for(int s  = 0; )
		
	}
	
	

}
