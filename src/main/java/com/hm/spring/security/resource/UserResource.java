package com.hm.spring.security.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	public UserResource() {
		
	}
	
	@GetMapping("user")
	public String getUser() {
		return "READ_USER";
	}
	
	@PostMapping("user")
	public String createUser() {
		return "CREATE_USER";
	}
	
	@DeleteMapping("user")
	public String deleteUser() {
		return "DELETE_USER";
	}
	
	@PutMapping("user")
	public String updateUser() {
		return "UPDATE_USER";
	}
}
