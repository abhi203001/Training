package com.example.order.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.order.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
	

}
