package com.sitrus.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sitrus.repository.UserRepository;
import com.sitrus.user.model.User;
import com.sitrus.user.service.UserService;

@RestController
public class SitrusController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public void createUserObject(@RequestBody String enteredUser) {
		System.out.println(enteredUser);
		createUser(enteredUser);
	}

	public User createUser(String userString) {

		// Create a new user object, a delimiter we use to split up our string passed
		// in, and arrays to store information
		// as we work with it.
		User enteredUser = new User();
		String delims = "[&]";
		ArrayList<String> allInfo = new ArrayList<>();
		String newStringToAdd;

		// Take our string that is passed in, and split the string up based on our
		// delimiter we set above,
		// which is the & symbol
		String[] parsedString = userString.split(delims);

		// Go through our string array that has been split up into sections, and now
		// split it up on the = symbol so we take everything after the = and push it
		// into our array list.
		for (int i = 0; i < parsedString.length; i++) {
			String str = parsedString[i].substring(parsedString[i].indexOf("=") + 1);
			allInfo.add(str);

		}

		// The emails passed in get the @ replaced with a % symbol, so to undo that we
		// get the email adress, and we replace the % with an @ and then replace the
		// email with
		// the fixed email in our array list before we make our User object.
		newStringToAdd = allInfo.get(4);
		newStringToAdd = newStringToAdd.replace('%', '@');
		allInfo.set(4, newStringToAdd);

		// Take all the information that has been passed in, and go through it 1 by one
		// to create our user.
		// The information passed in will always be in the same order, so we can set our
		// user object
		// like we do below.
		enteredUser.setUsername(allInfo.get(0));
		enteredUser.setUserPassword(allInfo.get(1));
		enteredUser.setFirstName(allInfo.get(2));
		enteredUser.setLastName(allInfo.get(3));
		enteredUser.setEmail(allInfo.get(4));
		enteredUser.setZip(allInfo.get(5));
		enteredUser.setUserType(allInfo.get(6));

		userRepo.save(enteredUser);

		System.out.println(enteredUser.toString());

		// Return the user object we created and set the fields of.
		return enteredUser;
	}

	// display forget password page

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView displayForgetPass() {

		return new ModelAndView("forgotPassword");

	}

	// process reset password form
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView setNewPass(ModelAndView modelAndView, RedirectAttributes redir, User user) {

		// find user by email
		Optional<User> opUser = userService.findUserByEmail(user.getEmail());

		if(opUser.isPresent()) {
			
		
			
			
			
		}
		
		
		

	}

}
