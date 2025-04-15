package com.example.Bookstore.ControllerLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.Model.OrderRequest;
import com.example.Bookstore.Model.OrderResponse;
import com.example.Bookstore.ServiceLayer.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	
	@Autowired 
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest){
		
		return orderService.placeOrder(orderRequest);
	}
}
