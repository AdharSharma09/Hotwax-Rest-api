package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "PARTY_ID", length = 40, nullable = false)
	private String partyId;

	@Column(name = "SALUTATION", length = 255)
	private String salutation;

	@Column(name = "FIRST_NAME", length = 255)
	private String firstName;

	@Column(name = "MIDDLE_NAME", length = 255)
	private String middleName;

	@Column(name = "LAST_NAME", length = 255)
	private String lastName;

	@Column(name = "GENDER", length = 1)
	private char gender;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "MARITAL_STATUS_ENUM_ID", length = 40)
	private String maritalStatusEnumId;

	@Column(name = "EMPLOYMENT_STATUS_ENUM_ID", length = 40)
	private String employmentStatusEnumId;

	@Column(name = "OCCUPATION", length = 255)
	private String occupation;

	@OneToOne
	@JoinColumn(name = "PARTY_ID", referencedColumnName = "PARTY_ID", insertable = false, updatable = false)
	private Party party;

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatusEnumId() {
		return maritalStatusEnumId;
	}

	public void setMaritalStatusEnumId(String maritalStatusEnumId) {
		this.maritalStatusEnumId = maritalStatusEnumId;
	}

	public String getEmploymentStatusEnumId() {
		return employmentStatusEnumId;
	}

	public void setEmploymentStatusEnumId(String employmentStatusEnumId) {
		this.employmentStatusEnumId = employmentStatusEnumId;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String partyId, String salutation, String firstName, String middleName, String lastName, char gender,
			Date birthDate, String maritalStatusEnumId, String employmentStatusEnumId, String occupation, Party party) {
		super();
		this.partyId = partyId;
		this.salutation = salutation;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.maritalStatusEnumId = maritalStatusEnumId;
		this.employmentStatusEnumId = employmentStatusEnumId;
		this.occupation = occupation;
		this.party = party;
	}
}
