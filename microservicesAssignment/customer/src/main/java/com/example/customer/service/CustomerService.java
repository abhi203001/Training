package com.example.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository cr;
	
	@Transactional
	public String createCustomer(Customer customer) {
		cr.save(customer);
		return ("Customer created successfully with ID: "+customer.getCid());
	}
	
	@Transactional
	public Optional<Customer> getCustomerById(String id) {
		return cr.findById(id);
	}
	
}
