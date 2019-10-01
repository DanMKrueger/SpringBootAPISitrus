package com.sitrus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sitrus.service.UserService;

@RestController
public class SitrusController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public @ResponseBody int createUserObject(@RequestBody String enteredUser) {
		//System.out.println(enteredUser);
		int msg = userService.createUser(enteredUser);
		return msg;
	}

	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public @ResponseBody int LoginUser(@RequestBody String enteredString) throws Exception {
		int msg = userService.userLogin(enteredString);
		return msg;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/passwordreset")
	public @ResponseBody int ResetPass(@RequestBody String enteredString) throws Exception {
		int msg = userService.ResetPassword(enteredString);
		return msg;
	}	
}
