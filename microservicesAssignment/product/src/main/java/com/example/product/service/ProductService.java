package com.example.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository pr;
	
	public String createCustomer(Product product) {
		pr.save(product);
		return ("Customer created successfully with ID: "+product.getId());
	}
	
	@Transactional
	public List<Product> getAllproducts(){
		return pr.findAll();
	}
	
	@Transactional
	public Optional<Product> getProductById(String id) {
		return pr.findById(id);
	}
}
