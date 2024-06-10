package com.catalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.catalogservice.entities.Order;
import com.catalogservice.repositories.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	
	public Order saveOrder(Order order) {
		Order save = orderRepo.save(order);
		return save;
	}
	
	public List<Order> allOrders(){
		return orderRepo.findAll();
	}
	
	public List<Order> byCategory(String category){
		return orderRepo.findByCategory(category);
	}

}
