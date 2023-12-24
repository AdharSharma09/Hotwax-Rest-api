package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, String description, char chargeShipping, char returnable,
			Party ownerParty) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.chargeShipping = chargeShipping;
		this.returnable = returnable;
		this.ownerParty = ownerParty;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getChargeShipping() {
		return chargeShipping;
	}

	public void setChargeShipping(char chargeShipping) {
		this.chargeShipping = chargeShipping;
	}

	public char getReturnable() {
		return returnable;
	}

	public void setReturnable(char returnable) {
		this.returnable = returnable;
	}

	public Party getOwnerParty() {
		return ownerParty;
	}

	public void setOwnerParty(Party ownerParty) {
		this.ownerParty = ownerParty;
	}

	@Id
	private String productId;

	private String productName;
	private String description;
	private char chargeShipping;
	private char returnable;

	@ManyToOne
	@JoinColumn(name = "owner_party_id")
	private Party ownerParty;
}
