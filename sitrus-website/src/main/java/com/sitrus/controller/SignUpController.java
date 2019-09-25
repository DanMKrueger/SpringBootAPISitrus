package com.sitrus.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sitrus.user.model.User;


@RestController
public class SignUpController {
	
	@RequestMapping(method=RequestMethod.PUT, value="/signup")
	public void printUser(@RequestBody User user) {
		System.out.println(user.toString());
	}

}
