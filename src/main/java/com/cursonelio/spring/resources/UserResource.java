package com.cursonelio.spring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursonelio.spring.entities.User;

@RestController
@RequestMapping(value="/users")

public class UserResource {

	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "agão", "agão@email.com", "agão telefone", "agão Password");
		return ResponseEntity.ok().body(u);
	}
	
}
