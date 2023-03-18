package com.project.questaqq.core.utilities.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.questaqq.core.utilities.jwt.security.JwtUserDetails;
import com.project.questaqq.dataAccess.abstracts.UserRepository;
import com.project.questaqq.entities.concrete.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsManager implements UserDetailsService{
	
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(username);
		
		return JwtUserDetails.create(user);
	}
	
	public UserDetails loadUserById(Long id) {
		
		User user = userRepository.findById(id).get();
		
		return JwtUserDetails.create(user);
	}

}
