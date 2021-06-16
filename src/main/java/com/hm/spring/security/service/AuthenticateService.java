package com.hm.spring.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hm.spring.security.config.AuthenticatUser;
import com.hm.spring.security.model.User;
import com.hm.spring.security.repository.AuthenticationRepository;

@Service
public class AuthenticateService implements UserDetailsService{
	@Autowired
	private AuthenticationRepository authenticationRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = authenticationRepository.findByUserName(userName);
		return user.map(AuthenticatUser::new).get();
	}	
}