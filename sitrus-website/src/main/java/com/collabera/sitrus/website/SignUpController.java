package com.collabera.sitrus.website;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
	
	@GetMapping("/hello")
	public static String sayHello() {
		System.out.println("Here");
		return "Hello!";
	}
	
	

}
