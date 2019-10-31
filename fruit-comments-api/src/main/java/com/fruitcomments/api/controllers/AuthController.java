package com.fruitcomments.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fruitcomments.api.viewmodels.LoginViewModel;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from the other side -8-";
	}
	
	@GetMapping("/sayHello")
	public String sayHello(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") java.util.Optional<String> surName
			) {
		return String.format("Hello %s %s", firstName, surName.isPresent()? surName.get() : "No Surname");
	}

	@GetMapping("/user/{username}")
	public LoginViewModel getUser(
			@PathVariable("username") String username
			) {
		LoginViewModel data = new LoginViewModel(username,"never send user password");
		return data;
	}
	
	@PostMapping("/login")
	public String login( 
			@RequestBody LoginViewModel credentials
			) {
		return String.format("Fake-Token-%s-%s",credentials.getUsername(),
				credentials.getPassword());
	}
	
	
	

}
