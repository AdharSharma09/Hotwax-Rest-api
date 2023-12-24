package com.example.demo.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {
	@EmbeddedId
	private OrderItemId orderItemId;

	@ManyToOne
	@JoinColumn(name = "ORDER_PART_SEQ_ID", insertable = false, updatable = false)
	private OrderPart orderPart;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false)
	private Product product;

	@Column(name = "ITEM_DESCRIPTION")
	private String itemDescription;

	@Column(name = "QUANTITY")
	private BigDecimal quantity;

	@Column(name = "UNIT_AMOUNT")
	private BigDecimal unitAmount;

	@Column(name = "ITEM_TYPE_ENUM_ID")
	private String itemTypeEnumId;

	@Column(name = "PARENT_ITEM_SEQ_ID")
	private String parentItemSeqId;

	// getters and setters

	public OrderItemId getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(OrderItemId orderItemId) {
		this.orderItemId = orderItemId;
	}

	public OrderPart getOrderPart() {
		return orderPart;
	}

	public void setOrderPart(OrderPart orderPart) {
		this.orderPart = orderPart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(BigDecimal unitAmount) {
		this.unitAmount = unitAmount;
	}

	public String getItemTypeEnumId() {
		return itemTypeEnumId;
	}

	public void setItemTypeEnumId(String itemTypeEnumId) {
		this.itemTypeEnumId = itemTypeEnumId;
	}

	public String getParentItemSeqId() {
		return parentItemSeqId;
	}

	public void setParentItemSeqId(String parentItemSeqId) {
		this.parentItemSeqId = parentItemSeqId;
	}

}