package com.example.Bookstore.Model;

public class OrderItemResponse {

	private String bookTitle;
	private double price;
	private int quantity;
	
	
	public OrderItemResponse() {
		
	}
	
	public OrderItemResponse(String bookTitle, double price, int quantity) {
		this.bookTitle = bookTitle;
		this.price = price;
		this.quantity = quantity;
	}
	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}
	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
