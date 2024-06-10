package com.catalogservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order_details")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private String  color;
	private int price;
	
	@PrePersist
	@PreUpdate
	public void ConvertFeildsToLowerCase() {
		if(name != null) {
			name = name.toLowerCase();
		}
		if(category != null) {
			category = category.toLowerCase();
		}
		if(color != null) {
			color = color.toLowerCase();
		}
	}
}


