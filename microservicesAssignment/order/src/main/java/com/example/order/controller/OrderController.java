package com.example.order.controller;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.model.Order;
import com.example.order.model.OrderGet;
import com.example.order.service.OrderService;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
	private static final Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	OrderService os;
	
	@PostMapping("/")
	public String createOrder(@RequestBody Order order) {
		
		logger.log(Level.INFO,"Entering into Create order function"+order);	
		return os.createOrder(order);
	}
	
	@GetMapping("/{id}")
	public OrderGet getOrderById(@PathVariable(value = "id") String id){
		logger.log(Level.INFO,"Entering into getOrderById function"+id);
		return os.getOrderById(id);
//		return os.getOrderById(id);
	}
}
