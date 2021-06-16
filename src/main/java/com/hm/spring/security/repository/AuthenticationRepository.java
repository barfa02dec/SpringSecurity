package com.hm.spring.security.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hm.spring.security.model.User;

@Repository
public interface AuthenticationRepository extends CrudRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
