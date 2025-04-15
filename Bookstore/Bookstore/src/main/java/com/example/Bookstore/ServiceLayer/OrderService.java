package com.example.Bookstore.ServiceLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Model.OrderItemRequest;
import com.example.Bookstore.Model.OrderItemResponse;
import com.example.Bookstore.Model.OrderRequest;
import com.example.Bookstore.Model.OrderResponse;
import com.example.Bookstore.Repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	private BookService bookService;

	@Autowired
	public OrderService(BookService bookService) {
		this.bookService = bookService;
	}

	@Transactional
	public ResponseEntity<?> placeOrder(OrderRequest orderRequest) {
		List<OrderItemResponse> responseOrderItem = new ArrayList<>();
		double totalPrice = 0.0;
		Book book;
		// validate request is not empty
		if (orderRequest.getOrderItems() == null || orderRequest.getOrderItems().isEmpty()) {

			return ResponseEntity.badRequest().body("Order must contain at least one order item.");
		}

		// loop through the order items
		for (OrderItemRequest orderItemRequest : orderRequest.getOrderItems()) {
			book = bookService.getBook(orderItemRequest.getBookId());

			// validate stock for each book
			if (book.getStock() < orderItemRequest.getQuantity()) {
				return ResponseEntity.badRequest().body("Insufficient stock for book: " + book.getTitle());
			}

			totalPrice += orderItemRequest.getQuantity() * book.getPrice();

			responseOrderItem
					.add(new OrderItemResponse(book.getTitle(), book.getPrice(), orderItemRequest.getQuantity()));

		}
		if (totalPrice > 120) {

			return ResponseEntity.badRequest().body("Order total exceeds allowed limit of $120.");
		}
		for (OrderItemRequest orderItemRequest : orderRequest.getOrderItems()) {
			bookService.updateStock(orderItemRequest.getBookId(), (-orderItemRequest.getQuantity()));

		}

		return ResponseEntity.ok(new OrderResponse(responseOrderItem, totalPrice));
	}

}
