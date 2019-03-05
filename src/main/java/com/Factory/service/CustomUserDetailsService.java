package com.Factory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Factory.entity.User;
import com.Factory.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt = userRepository.findByUsernameWithRole(username);
		if (opt.isPresent()) {
			// return d'un UserDetails
			return new CustomUserDetails(opt.get());
		}
		throw new UsernameNotFoundException("Erreur, Utilisateur inexistant");
	}

}
