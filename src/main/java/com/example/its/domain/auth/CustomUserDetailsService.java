package com.example.its.domain.auth;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.its.domain.auth.User.Authority;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username)
			.map(
					user -> new CustomUserDetails(
							user.getEmail(),
							user.getPassword(),
							toGrantedAuthorityList(user.getAuthority())
					)
			)
			
			.orElseThrow(
					() -> new UsernameNotFoundException(
							"Given username is not found. (username" + username + ")"
					)
			);
	}

	private List<GrantedAuthority> toGrantedAuthorityList(User.Authority authority) {
		return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
	}
}