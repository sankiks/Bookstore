package com.example.Bookstore.Model;

public class OrderItemRequest {
	private Long bookId;
	private int quantity;
	
	
	public OrderItemRequest() {
		
	}
	
	public OrderItemRequest(Long bookId, int quantity) {
		this.bookId = bookId;
		this.quantity = quantity;
	}
	/**
	 * @return the bookIdLong
	 */
	public Long getBookId() {
		return bookId;
	}
	/**
	 * @param bookIdLong the bookIdLong to set
	 */
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
