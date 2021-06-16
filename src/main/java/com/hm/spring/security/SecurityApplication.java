package com.hm.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hm.spring.security.repository.AuthenticationRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AuthenticationRepository.class)
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
