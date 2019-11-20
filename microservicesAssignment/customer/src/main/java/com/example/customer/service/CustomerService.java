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
	public Customer createCustomer(Customer customer) {
		return cr.save(customer);
		
	}
	
	@Transactional(readOnly=true)
	public Optional<Customer> getCustomerById(String id) {
		return cr.findById(id);
	}
	
}
