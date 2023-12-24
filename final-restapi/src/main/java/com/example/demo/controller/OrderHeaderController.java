package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.OrderHeader;
import com.example.demo.services.OrderHeaderService;

@RestController
@RequestMapping("/api/orderHeaders")
public class OrderHeaderController {
	@Autowired
	private OrderHeaderService orderHeaderService;

	@GetMapping
	public List<OrderHeader> getAllOrders() {
		return orderHeaderService.getAllOrders();
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<OrderHeader> getOrderById(@PathVariable String orderId) {
		Optional<OrderHeader> orderHeader = orderHeaderService.getOrderById(orderId);

		return orderHeader.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<OrderHeader> createOrder(@RequestBody OrderHeader orderHeader) {
		OrderHeader createdOrder = orderHeaderService.createOrder(orderHeader);
		return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	}

	@PutMapping("/{orderId}")
	public ResponseEntity<OrderHeader> updateOrderName(@PathVariable String orderId,
			@RequestParam String newOrderName) {
		OrderHeader updatedOrder = orderHeaderService.updateOrderName(orderId, newOrderName);

		if (updatedOrder != null) {
			return ResponseEntity.ok(updatedOrder);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
