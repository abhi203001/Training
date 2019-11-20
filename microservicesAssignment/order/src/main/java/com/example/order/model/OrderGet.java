package com.example.order.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class OrderGet {

	private Customer customer;
	private ArrayList<Product> orderLineItems;
	private double totalPrice;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Product> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(ArrayList<Product> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

	public OrderGet(Customer customer, ArrayList<Product> orderLineItems) {
		super();
		this.customer = customer;
		this.orderLineItems = orderLineItems;
	}

	public OrderGet() {
		super();
	}

	@Override
	public String toString() {
		return "OrderGet [customer=" + customer + ", orderLineItems=" + orderLineItems + ", totalPrice=" + totalPrice
				+ ", getTotalPrice()=" + getTotalPrice() + ", getCustomer()=" + getCustomer() + ", getOrderLineItems()="
				+ getOrderLineItems() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
