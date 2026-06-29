package com.ganesh.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome We Are Lerning Security";
	}
	
	
	@GetMapping("/greet")
	public String greet() {
		
		return "Good Morning";
	}

}
