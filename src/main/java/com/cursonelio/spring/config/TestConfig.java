package com.cursonelio.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursonelio.spring.entities.Category;
import com.cursonelio.spring.entities.Order;
import com.cursonelio.spring.entities.OrderItem;
import com.cursonelio.spring.entities.Payment;
import com.cursonelio.spring.entities.Product;
import com.cursonelio.spring.entities.User;
import com.cursonelio.spring.entities.enums.OrderStatus;
import com.cursonelio.spring.repositories.CategoryRepository;
import com.cursonelio.spring.repositories.OrderItemRepository;
import com.cursonelio.spring.repositories.OrderRepository;
import com.cursonelio.spring.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
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
		
		Product p1 = new Product(null, "Computador", "Core i5 9400f", 3800.00 , "");
		Product p2 = new Product(null, "Computador", "Core i9 9900x", 5800.00 , "");
		Product p3 = new Product(null, "Senhor dos anéis", "As duas torres", 70.00 , "");
		Product p4 = new Product(null, "Percy Jackson", "Ladrão de Raios", 50.00 , "");
		Product p5 = new Product(null, "Tapete", "Tapete de chão", 80.00, "");
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3,1,p4.getPrice());
		OrderItem oi3 = new OrderItem(o2,p3,2,p1.getPrice());
		OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice());
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat2);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat3);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2,oi3,oi4));
		
	}	
}
