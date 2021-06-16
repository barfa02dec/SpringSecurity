package com.hm.spring.security.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.spring.security.model.AuthenticateRequest;
import com.hm.spring.security.model.AuthenticateResponse;
import com.hm.spring.security.service.AuthenticateService;
import com.hm.spring.security.util.JwtUtil;

@RestController
public class HomeResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthenticateService authenticateService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
    @PostMapping("/authentication")
    public AuthenticateResponse getAuthentication(@RequestBody AuthenticateRequest authenticateRequest){
    	try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword()));
    	}catch (BadCredentialsException e) {
    		e.printStackTrace();
    		throw new BadCredentialsException("Invalid credentails");
    	}
    	final UserDetails userDetails = authenticateService.loadUserByUsername(authenticateRequest.getUserName());
    	final String jwtToken = jwtUtil.generateToken(userDetails);
    	return new AuthenticateResponse(jwtToken);
   }
}
