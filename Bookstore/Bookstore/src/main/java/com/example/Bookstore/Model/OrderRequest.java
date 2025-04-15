package com.example.Bookstore.Model;

import java.util.List;

public class OrderRequest {

	private List<OrderItemRequest> orderItems;

	
	public OrderRequest() {
		
	}
	
	public OrderRequest(List<OrderItemRequest> orderItems) {
		
		this.orderItems = orderItems;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItemRequest> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItemRequest> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	
	
}
