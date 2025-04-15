package com.example.Bookstore.Model;

public class RestockRequest {
	
	private Long bookId;
	private int quantity;
	
	public RestockRequest() {
		
	}

	public RestockRequest(Long bookIdLong, int quantity) {
	
		this.bookId = bookIdLong;
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
	public void setBookId(Long bookIdLong) {
		this.bookId = bookIdLong;
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
