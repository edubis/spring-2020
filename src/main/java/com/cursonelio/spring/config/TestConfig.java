package com.cursonelio.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursonelio.spring.entities.Category;
import com.cursonelio.spring.entities.Order;
import com.cursonelio.spring.entities.User;
import com.cursonelio.spring.entities.enums.OrderStatus;
import com.cursonelio.spring.repositories.CategoryRepository;
import com.cursonelio.spring.repositories.OrderRepository;
import com.cursonelio.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
		
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "José", "José email", "José telefone", "José password");
		User u2 = new User(null, "Maria", "Maria email", "Maria telefone", "Maria password");
		
		
		Order o1 = new Order(null, Instant.parse("2020-11-24T09:24:10Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2020-11-24T14:44:50Z"), u2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2020-11-24T19:13:06Z"),u1, OrderStatus.SHIPPED);
		
		Category cat1 = new Category(null, "Eletrônico");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Domésticos");
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}	
}
