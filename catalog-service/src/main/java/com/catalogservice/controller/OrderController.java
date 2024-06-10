package com.catalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalogservice.entities.Order;
import com.catalogservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService; 
	
	@GetMapping("/getOrders")
	public List<Order> getAllorders(){
		return orderService.allOrders();
	}
	
	@PostMapping("/saveorder")
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/byCategory")
	public List<Order> byCategory(@RequestParam(name = "category") String category){
		return orderService.byCategory(category);
	}
	
	

}
