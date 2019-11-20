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
		return ("Order created with ID: " + order.getCid());
	}

	@Transactional(readOnly = true)
	public OrderGet getOrderById(String id) {
//		double[] totalPrice = {0};
		String customerId = or.findById(id).get().getCid();
		Customer customer = restTemplate.getForObject("http://Customer/v1/customer/" + customerId, Customer.class);
		orderGet.setCustomer(customer);

		ArrayList<OrderLineItems> orderLineItems = or.findById(id).get().getOrderLineItems();
		ArrayList<String> productId = new ArrayList<>();
		orderLineItems.forEach(item -> {
			productId.add(item.getProductId());
//			totalPrice[0]+=item.getPrice();
		});

		ArrayList<Product> product = new ArrayList<>();
		productId.forEach(pid -> {
			product.add(restTemplate.getForObject("http://Product/v1/getProductById?id=" + pid,
					Product.class));
		});
		orderGet.setOrderLineItems(product);
//		orderGet.setTotalPrice(totalPrice[0]);
		return orderGet;

	}
}