package com.cursonelio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursonelio.spring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
