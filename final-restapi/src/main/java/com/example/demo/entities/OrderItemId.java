package com.example.demo.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


public class OrderItemId {
	private String orderId;
	private String orderItemSeqId;

	@Override
	public int hashCode() {
		return Objects.hash(orderId, orderItemSeqId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemId other = (OrderItemId) obj;
		return Objects.equals(orderId, other.orderId) && Objects.equals(orderItemSeqId, other.orderItemSeqId);
	}

	public OrderItemId(String orderId, String orderItemSeqId) {
		super();
		this.orderId = orderId;
		this.orderItemSeqId = orderItemSeqId;
	}

	public OrderItemId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderItemSeqId() {
		return orderItemSeqId;
	}

	public void setOrderItemSeqId(String orderItemSeqId) {
		this.orderItemSeqId = orderItemSeqId;
	}

	// constructors, getters, setters, and equals/hashCode methods

	// make sure to implement equals and hashCode methods
}
