package com.cursonelio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursonelio.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
