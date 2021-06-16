package com.hm.spring.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.hm.spring.security.model.User;

@Component
public class AuthenticatUser implements UserDetails{
	
	private User user;
	
	public AuthenticatUser(User user) {
		this.user = user;
	}
	public AuthenticatUser() {
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		this.user.getPermissionList().forEach( p -> {
			GrantedAuthority authority = new SimpleGrantedAuthority(p);
			authorities.add(authority);
		});
		this.user.getRoleList().forEach( r -> {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
			authorities.add(authority);
		});
		return authorities;
	}
	
	@Override
	public String getUsername() {
		return this.user.getUserName();
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	public User getUser() {
		return user;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
