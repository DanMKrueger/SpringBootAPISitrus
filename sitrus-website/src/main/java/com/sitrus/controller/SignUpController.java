package com.sitrus.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
public class SignUpController {
	
	@RequestMapping(method=RequestMethod.PUT, value="/signup")
	public void printUser(@RequestBody ObjectNode objNode) {
		System.out.println(objNode.get("str1").asText());
	}

}
