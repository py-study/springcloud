package com.oe.edu.security;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oe.edu.dao.user.UserEntity;
import com.oe.edu.dao.user.UserRepository;

@Service
public class customerUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserEntity> optional = userRepository.findByName(username);
		
		optional.orElseThrow(()-> new UsernameNotFoundException(username + " not found"));

		return optional.map(customerUserDetail::new).get();
	}

}
