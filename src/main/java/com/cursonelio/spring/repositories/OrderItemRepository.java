package com.cursonelio.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursonelio.spring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
