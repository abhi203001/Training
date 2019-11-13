package com.example.order.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.order.model.Customer;
import com.example.order.model.Order;
import com.example.order.model.OrderGet;
import com.example.order.model.OrderLineItems;
import com.example.order.model.Product;
import com.example.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository or;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	OrderGet orderGet;

	@Transactional
	public String createOrder(Order order) {
		or.save(order);
		return ("Order create with ID: " + order.getCid());
	}

	@Transactional(readOnly = true)
	public OrderGet getOrderById(String id) {
		System.out.println(id);
		String customerId = or.findById(id).get().getCid();
		System.out.println("Customer ID: " + customerId);
		Customer customer = restTemplate.getForObject("http://Customer/v1/customer/"+customerId , Customer.class);
		orderGet.setCustomer(customer);
		ArrayList<OrderLineItems> orderLineItems = or.findById(id).get().getOrderLineItems();
		ArrayList<String> productId = new ArrayList<>();
		orderLineItems.forEach(item -> {
			productId.add(item.getProductId());
		});

		ArrayList<Product> product = new ArrayList<>();
		productId.forEach(id1 -> {
			System.out.println("productId is :-->" + id1);
			product.add(restTemplate.getForObject("http://Product/api.triconinfotech.com/v1/getProductById?id=" + id1,
					Product.class));
		});
		orderGet.setOrderLineItems(product);
		return orderGet;

	}
}