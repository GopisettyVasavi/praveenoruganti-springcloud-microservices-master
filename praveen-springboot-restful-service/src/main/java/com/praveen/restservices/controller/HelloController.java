package com.praveen.restservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.restservices.model.User1;
@RestController
@RequestMapping("/rest/hello")
public class HelloController {

	@GetMapping("/getMsg")
	public String greeting() {
		return "Welcome To Praveen Oruganti User Forum !!";
	}
	
	@GetMapping("/getMsgBean")
	public User1 greetingBean() {		
		return new User1(149903,"PraveenOruganti","praveenoruganti@gmail.com","Hyderabad");
	}

}
