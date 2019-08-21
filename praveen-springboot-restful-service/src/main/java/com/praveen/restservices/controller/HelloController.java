package com.praveen.restservices.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@GetMapping("/getMsgBean/path-variable/{name}")
	public User1 greetingBean(@PathVariable String name) {		
		return new User1(149903,name,"praveenoruganti@gmail.com","Hyderabad");
	}
	
	@PostMapping("/getMsgBean")
	public ResponseEntity<User1> greetingBean(@RequestBody User1 user1,UriComponentsBuilder builder) {		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/getMsgBean/{userName}").buildAndExpand(user1.getUserName()).toUri());
		return new ResponseEntity<User1>(headers, HttpStatus.CREATED);
	}

}
