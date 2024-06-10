package com.userservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@SpringBootApplication
@RestController
@RequestMapping("/user-service")
public class UserServiceApplication {
	
	@Autowired
	@Lazy
	private RestTemplate template;
	
	private static final String BASEURL="http://localhost:8080/orders";
	
	@GetMapping("/displayorders")
	@CircuitBreaker(name = "userService" ,fallbackMethod = "getAllavailableProducts")
	public List<OrderDTO> displayOrders(@RequestParam(name = "category") String category){
		String url = BASEURL+"/byCategory?category="+category;
		System.out.println(url);
		return template.getForObject(url, List.class);
				
	}
	
	public List<OrderDTO> getAllavailableProducts(Exception exception){
		List<OrderDTO> list = Arrays.asList(new OrderDTO(0,"Productname","Producttype","productcolor",0));
		return list;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
