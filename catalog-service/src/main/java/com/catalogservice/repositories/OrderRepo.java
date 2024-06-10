package com.catalogservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalogservice.entities.Order;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
	
	List<Order> findByCategory(String category);

}
