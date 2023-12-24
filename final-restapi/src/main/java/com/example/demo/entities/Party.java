package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "party")
public class Party {
	public Party() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getPartyTypeEnumId() {
		return partyTypeEnumId;
	}

	public void setPartyTypeEnumId(String partyTypeEnumId) {
		this.partyTypeEnumId = partyTypeEnumId;
	}

	public Party(String partyId, String partyTypeEnumId) {
		super();
		this.partyId = partyId;
		this.partyTypeEnumId = partyTypeEnumId;
	}

	@Id
	private String partyId;

	private String partyTypeEnumId;
}
