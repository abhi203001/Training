package com.example.customer.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {
private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService cs;
	
	@PostMapping("/")
	public Customer createCustomer(@RequestBody Customer customer) {
		logger.info("Creating the customer"+customer);
		return cs.createCustomer(customer);
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable(value = "id") String id){
		logger.info("Entering into getCustomerById function"+id);
		return cs.getCustomerById(id);
	}
}
