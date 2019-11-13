package com.example.product.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.product.model.Product;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("api.triconinfotech.com/v1")
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	ProductService ps;	
	
	@PostMapping("/")
	public String createCustomer(@RequestBody Product product) {
		logger.info("Creating the Product"+product);
		return ps.createCustomer(product);
	}
	
	@GetMapping("/products")
	public List<?> productList(){
		logger.log(Level.INFO,"Product List Function");	
		return ps.getAllproducts();
	}
	
	@GetMapping("/getProductById")
	public Optional<Product> getProductById(@RequestParam("id") String id){
		logger.log(Level.INFO,"Product List Function"+id);	
		return ps.getProductById(id);
	}

}
