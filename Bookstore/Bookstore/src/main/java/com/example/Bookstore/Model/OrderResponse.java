package com.example.Bookstore.Model;

import java.util.List;

public class OrderResponse {
	List<OrderItemResponse> orderItems;
	private double totalPrice;
	
	
	public OrderResponse() {
		
	}
	public OrderResponse(List<OrderItemResponse> orderItems, double totalPrice) {
		this.orderItems = orderItems;
		this.totalPrice=totalPrice;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItemResponse> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItemResponse> orderItems) {
		this.orderItems = orderItems;
	}
	
	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
