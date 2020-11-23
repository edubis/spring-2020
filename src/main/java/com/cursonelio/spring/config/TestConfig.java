package com.cursonelio.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursonelio.spring.entities.User;
import com.cursonelio.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
		
	@Autowired
	private UserRepository userRepository;

	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "José", "José email", "José telefone", "José password");
		User u2 = new User(null, "Maria", "Maria email", "Maria telefone", "Maria password");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}	
}
