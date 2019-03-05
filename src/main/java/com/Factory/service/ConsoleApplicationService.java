package com.Factory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Factory.entity.User;
import com.Factory.repository.UserRepository;

@Service
public class ConsoleApplicationService implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
//		List<User> users = userRepository.findAll();
//	for (User user : users) {
//			user.setPassword(passwordEncoder.encode(user.getUsername()));
//	userRepository.save(user);
//	}
	}

}
