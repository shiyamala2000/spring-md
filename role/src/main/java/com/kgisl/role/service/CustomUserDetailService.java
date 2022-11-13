package com.kgisl.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kgisl.role.model.User;
import com.kgisl.role.repository.UserRepository;

public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		if(user==null) {
			throw new UsernameNotFoundException("No user Found for the name");
		}
		return new CutomUserDetails(user);
	}

}
