package com.sitrus.controller.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitrus.repository.UserRepository;
import com.sitrus.user.model.User;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepo;
	
/******************************* User Login *******************************/

	
	public int userLogin(String enteredString)  throws Exception{
		//user_name=DMKrueger&user_password=asdfsaf
		User enteredUser = new User();
		
		int msg = 0;
		
		String delim = "[&]";
		ArrayList<String> allInfo = new ArrayList<>();
		
		String[] parsedString = enteredString.split(delim);
		for(int i = 0; i < parsedString.length; i++) {
			String str = parsedString[i].substring(parsedString[i].indexOf("=")+1);
			allInfo.add(str);
		}

		/* 
		 * Make an array list with the entire database in it. Then, we go through it one 
		 * User at a time and check the username and see if it is equal to the username that 
		 * was entered (allInfo.get(0)). If it is, that means that the user exists, so
		 * we set our int msg equal to 0, and break out of the for loop. If no user is found msg 
		 * will be equal to 1, and when we return 1 the JavaScript file takes that as no user being
		 * found with that user name, so that is the alert we show.
		*/
		ArrayList<User> allUsers = (ArrayList<User>) userRepo.findAll();
		for(int i = 0; i < allUsers.size(); i++) {
			if(allUsers.get(i).getUsername().equals(allInfo.get(0))) {
				enteredUser = allUsers.get(i);
				msg = 0;
				break;
			}
			else {
				msg = 1;
			}
		}
		/*
		 * If we get into the if statment under this comment, that means that msg was equal to 0, which
		 * means that there is a user in our databse with the username entered on the website.
		 * Now, we check the password. We take the entered password and compare it to the password
		 * we have stored in the database (allInfo.get(1)). If they match, we return 0 which is our code
		 * to show everything is correct. Otherwise, we return 1.
		 */
		if(msg == 0) {
			if(enteredUser.getUserPassword().equals(allInfo.get(1))) {
				msg = 0;
			}else {
				msg = 1;
			}
		}
		
		return msg;
	}
	
/******************************* Create User ********************************/
	
	public int createUser(String userString) {
		
		int msg = 1;
		/* Create a new user object, a delimiter we use to split up our string passed
		 * in, and arrays to store information
		 * as we work with it.
		*/
		
		User enteredUser = new User();
		String delims = "[&]";
		ArrayList<String> allInfo = new ArrayList<>();
		String newStringToAdd;

		/* 
		 * Take our string that is passed in, and split the string up based on our
		 * delimiter we set above, which is the & symbol
		 */
		String[] parsedString = userString.split(delims);

		/* Go through our string array that has been split up into sections, and now
		 * split it up on the = symbol so we take everything after the = and push it
		 * into our array list.
		 */
		for (int i = 0; i < parsedString.length; i++) {
			String str = parsedString[i].substring(parsedString[i].indexOf("=") + 1);
			allInfo.add(str);

		}

		/* 
		 * The emails passed in get the @ replaced with a % symbol, so to undo that we
		 *  get the email adress, and we replace the % with an @ and then replace the 
		 *  email with the fixed email in our array list before we make our User object.
		 */
		newStringToAdd = allInfo.get(4);
		newStringToAdd = newStringToAdd.replace("%40", "@");
		allInfo.set(4, newStringToAdd);
		

		/*
		 * We take our entire database and put it into an ArrayList named allUsers. Then with that we go through
		 * one entry at a time and check to see if the entered username(allInfo.get(0)) is equal to any of the usernames
		 * that is already in the database. If it is, we set msg = 1 and we break because that means the username is already taken,
		 * and when we return 1 in this method, 1 gets returned to the JS file and it knows that 1 is the code
		 * for the uesrname already being taken. If the username is not there, we make msg = 0 which is good. If it gets past all of that,
		 * we make an if statment to see if msg is 0. If it is, that means the username was not taken, so we do the same thing
		 * for the email. If the email is taken, we set msg = 2 so the JavaScript file knows what ot print out. If the email is not
		 * taken, we make msg = 0 like before. 
		 */
		ArrayList<User> allUsers = (ArrayList<User>) userRepo.findAll();
		for(int i = 0; i < allUsers.size(); i++) {
			if(allUsers.get(i).getUsername().equals(allInfo.get(0))) {
				msg = 1;
				break;
			}
			else {
				msg = 0;
			}
		}
		if(msg == 0) {
			for(int i = 0; i < allUsers.size(); i++) {
				if(allUsers.get(i).getEmail().equals(allInfo.get(4))) {
					msg = 2;
					break;
				}
				else {
					msg = 0;
				}
			}
		}
		
		
		/* Take all the information that has been passed in, and go through it 1 by one to create our user. 
		 * The information passed in will always be in the same order, so we can set our user object like 
		 * we do below. However, we only do the below steps if msg == 0 because if it is not 0, that means that we found out
		 * above that the user already exists, so we will not create another user with the same
		 * username or email.
		 */
		if(msg == 0) {
		
			enteredUser.setUsername(allInfo.get(0));
			enteredUser.setUserPassword(allInfo.get(1));
			enteredUser.setFirstName(allInfo.get(2));
			enteredUser.setLastName(allInfo.get(3));
			enteredUser.setEmail(allInfo.get(4));
			enteredUser.setZip(allInfo.get(5));
			enteredUser.setUserType(allInfo.get(6));
			msg = 0;
	
			userRepo.save(enteredUser);
	
			System.out.println(enteredUser.toString());
		}

		// Return the user object we created and set the fields of.
		return msg;
	}
	
	/**************************************** Reset Pass ****************************************/
	public int ResetPassword(String enteredString) throws Exception{
		User enteredUser = new User();
		
		int msg = 0;
		
		String delim = "[&]";
		ArrayList<String> allInfo = new ArrayList<>();
		/*
		 * Go through the string that was entered, and split it up on the &
		 */
		String[] parsedString = enteredString.split(delim);
		
		/*
		 * Go through the split up string, and just get the values that are to the right of the =
		 */
		for(int i = 0; i < parsedString.length; i++) {
			String str = parsedString[i].substring(parsedString[i].indexOf("=")+1);
			allInfo.add(str);
		}
				
		/*
		 * Make an array list, allUsers, and put the entire databsae in it. Now, we go through that
		 * one at a time and see if the username exists in the database. If it does, we take that user and put it 
		 * into our enteredUser object and set msg = 0 so we can use that later. If the username does not
		 * exist, we set msg = 1.
		 */
		ArrayList<User> allUsers = (ArrayList<User>) userRepo.findAll();
		for(int i = 0; i < allUsers.size(); i++) {
			if(allUsers.get(i).getUsername().equals(allInfo.get(0))) {
				enteredUser = allUsers.get(i);
				msg = 0;
				break;
			}
			else {
				msg = 1;
			}
		}
		
		/*
		 * If the username exists, we take the user object and update the password. Then, we save
		 * the entered user to the database so it updates the password.
		 */
		if(msg == 0) {
			enteredUser.setUserPassword(allInfo.get(1));
			userRepo.save(enteredUser);
		}
				
		return msg;
	}
	
}
