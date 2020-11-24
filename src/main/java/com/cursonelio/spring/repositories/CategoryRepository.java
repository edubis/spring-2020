package com.cursonelio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursonelio.spring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
