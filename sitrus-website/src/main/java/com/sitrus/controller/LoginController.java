package com.sitrus.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public void testing(@RequestBody String enteredUser) {
		System.out.println(enteredUser);
	}

}
