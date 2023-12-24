package com.example.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_part")
public class OrderPart {

	@EmbeddedId
	private OrderPartId id;

	@Column(name = "PART_NAME", length = 255)
	private String partName;

	@Column(name = "STATUS_ID", length = 40)
	private String statusId;

	@Column(name = "VENDOR_PARTY_ID", length = 40)
	private String vendorPartyId;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_PARTY_ID")
	private Party customerParty;

	@Column(name = "PART_TOTAL", precision = 24, scale = 4)
	private BigDecimal partTotal;

	@Column(name = "FACILITY_ID", length = 40)
	private String facilityId;

	@Column(name = "SHIPMENT_METHOD_ENUM_ID", length = 40)
	private String shipmentMethodEnumId;

	// Constructors, getters, and setters

	@Embeddable
	    public static class OrderPartId implements Serializable {

	        @Column(name = "ORDER_ID", length = 40)
	        private String orderId;

	        @Column(name = "ORDER_PART_SEQ_ID", length = 40)
	        private String orderPartSeqId;
}

	public OrderPart(OrderPartId id, String partName, String statusId, String vendorPartyId, Party customerParty,
			BigDecimal partTotal, String facilityId, String shipmentMethodEnumId) {
		super();
		this.id = id;
		this.partName = partName;
		this.statusId = statusId;
		this.vendorPartyId = vendorPartyId;
		this.customerParty = customerParty;
		this.partTotal = partTotal;
		this.facilityId = facilityId;
		this.shipmentMethodEnumId = shipmentMethodEnumId;
	}

	public OrderPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderPartId getId() {
		return id;
	}

	public void setId(OrderPartId id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getVendorPartyId() {
		return vendorPartyId;
	}

	public void setVendorPartyId(String vendorPartyId) {
		this.vendorPartyId = vendorPartyId;
	}

	public Party getCustomerParty() {
		return customerParty;
	}

	public void setCustomerParty(Party customerParty) {
		this.customerParty = customerParty;
	}

	public BigDecimal getPartTotal() {
		return partTotal;
	}

	public void setPartTotal(BigDecimal partTotal) {
		this.partTotal = partTotal;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getShipmentMethodEnumId() {
		return shipmentMethodEnumId;
	}

	public void setShipmentMethodEnumId(String shipmentMethodEnumId) {
		this.shipmentMethodEnumId = shipmentMethodEnumId;
	}
}
