package com.example.order.model;

public class OrderLineItems {

	private String productId;
	private int qty;
	private double unitPrice;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return unitPrice;
	}

	public void setPrice(double price) {
		this.unitPrice = price;
	}

}
