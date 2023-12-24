package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.OrderItem;
import com.example.demo.services.OrderItemService;

@RestController
@RequestMapping("/api/orderitems")
public class OrderitemController {

	private final OrderItemService orderItemService;

	@Autowired
	public OrderitemController(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	@GetMapping("/{orderId}/{orderItemSeqId}")
	public ResponseEntity<OrderItem> getOrderItem(@PathVariable String orderId, @PathVariable String orderItemSeqId) {
		OrderItem orderItem = orderItemService.getOrderItem(orderId, orderItemSeqId);
		return new ResponseEntity<>(orderItem, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<OrderItem>> getAllOrderItems() {
		List<OrderItem> orderItems = orderItemService.getAllOrderItems();
		return new ResponseEntity<>(orderItems, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> createOrderItem(@RequestBody OrderItem requestDto) {
		String result = orderItemService.createOrderItem(requestDto);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@PutMapping("/{orderId}/{orderItemSeqId}")
	public ResponseEntity<String> updateOrderItem(@PathVariable String orderId, @PathVariable String orderItemSeqId,
			@RequestBody OrderItem requestDto) {
		String result = orderItemService.updateOrderItem(orderId, orderItemSeqId, requestDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/{orderId}/{orderItemSeqId}")
	public ResponseEntity<String> deleteOrderItem(@PathVariable String orderId, @PathVariable String orderItemSeqId) {
		String result = orderItemService.deleteOrderItem(orderId, orderItemSeqId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
