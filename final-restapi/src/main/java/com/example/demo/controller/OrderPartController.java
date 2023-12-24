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

import com.example.demo.entities.OrderPart;
import com.example.demo.services.OrderPartService;

@RestController
@RequestMapping("/api/orderparts")
public class OrderPartController {

	private final OrderPartService orderPartService;

	@Autowired
	public OrderPartController(OrderPartService orderPartService) {
		this.orderPartService = orderPartService;
	}

	@GetMapping("/{orderId}/{orderPartSeqId}")
	public ResponseEntity<OrderPart> getOrderPartById(@PathVariable String orderId,
			@PathVariable String orderPartSeqId) {
		return orderPartService.getOrderPartById(orderId, orderPartSeqId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<OrderPart> getAllOrderParts() {
		return orderPartService.getAllOrderParts();
	}

	@PostMapping
	public ResponseEntity<OrderPart> createOrderPart(@RequestBody OrderPart orderPart) {
		OrderPart createdOrderPart = orderPartService.createOrderPart(orderPart);
		return new ResponseEntity<>(createdOrderPart, HttpStatus.CREATED);
	}

	@PutMapping("/{orderId}/{orderPartSeqId}")
	public ResponseEntity<OrderPart> updateOrderPart(@PathVariable String orderId, @PathVariable String orderPartSeqId,
			@RequestBody OrderPart updatedOrderPart) {
		try {
			OrderPart updatedPart = orderPartService.updateOrderPart(orderId, orderPartSeqId, updatedOrderPart);
			return ResponseEntity.ok(updatedPart);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{orderId}/{orderPartSeqId}")
	public ResponseEntity<Void> deleteOrderPart(@PathVariable String orderId, @PathVariable String orderPartSeqId) {
		orderPartService.deleteOrderPart(orderId, orderPartSeqId);
		return ResponseEntity.noContent().build();
	}

}