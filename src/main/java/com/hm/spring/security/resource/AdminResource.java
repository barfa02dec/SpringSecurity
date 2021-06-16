package com.hm.spring.security.resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminResource {

	public AdminResource() {
		
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "READ_ADMIN";
	}
	
	@PostMapping("/admin")
	public String createAdmin() {
		return "CREATE_ADMIN";
	}
	
	@DeleteMapping("/admin")
	public String deleteAdmin() {
		return "DELETE_ADMIN";
	}
	
	@PutMapping("/admin")
	public String updateAdmin() {
		return "UPDATE_ADMIN";
	}
}
