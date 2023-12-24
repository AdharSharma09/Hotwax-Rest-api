package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_header")
public class OrderHeader {

	@Id
	@Column(name = "ORDER_ID", length = 40, nullable = false)
	private String orderId;

	@Column(name = "ORDER_NAME", length = 255)
	private String orderName;

	@Column(name = "PLACED_DATE")
	private Date placedDate;

	@Column(name = "APPROVED_DATE")
	private Date approvedDate;

	@Column(name = "STATUS_ID", length = 40)
	private String statusId;

	@Column(name = "CURRENCY_UOM_ID", length = 40)
	private String currencyUomId;

	@Column(name = "PRODUCT_STORE_ID", length = 40)
	private String productStoreId;

	@Column(name = "SALES_CHANNEL_ENUM_ID", length = 40)
	private String salesChannelEnumId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getCurrencyUomId() {
		return currencyUomId;
	}

	public void setCurrencyUomId(String currencyUomId) {
		this.currencyUomId = currencyUomId;
	}

	public String getProductStoreId() {
		return productStoreId;
	}

	public void setProductStoreId(String productStoreId) {
		this.productStoreId = productStoreId;
	}

	public String getSalesChannelEnumId() {
		return salesChannelEnumId;
	}

	public void setSalesChannelEnumId(String salesChannelEnumId) {
		this.salesChannelEnumId = salesChannelEnumId;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public OrderHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderHeader(String orderId, String orderName, Date placedDate, Date approvedDate, String statusId,
			String currencyUomId, String productStoreId, String salesChannelEnumId, BigDecimal grandTotal,
			Date completedDate) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.placedDate = placedDate;
		this.approvedDate = approvedDate;
		this.statusId = statusId;
		this.currencyUomId = currencyUomId;
		this.productStoreId = productStoreId;
		this.salesChannelEnumId = salesChannelEnumId;
		this.grandTotal = grandTotal;
		this.completedDate = completedDate;
	}

	@Column(name = "GRAND_TOTAL", precision = 24, scale = 4)
	private BigDecimal grandTotal;

	@Column(name = "COMPLETED_DATE")
	private Date completedDate;

}
