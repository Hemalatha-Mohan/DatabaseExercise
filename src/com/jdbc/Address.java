package com.jdbc;

public class Address {
	
	
	private String AddCategories;
	private String Door_no;
	private String StreetName;
	private String City;
	private String state;
	private String Postalcode;
	private String Country;
	private String contact_id;
	private int Address_id;
	
	
	public Address(String addCategories, String door_no, String streetName, String city, String state,
			String postalcode, String country, String contact_id) {
		super();
		AddCategories = addCategories;
		Door_no = door_no;
		StreetName = streetName;
		City = city;
		this.state = state;
		Postalcode = postalcode;
		Country = country;
		this.contact_id = contact_id;
	}
	
	
	public Address(String addCategories, String door_no, String streetName, String city, String state,
			String postalcode, String country, String contact_id, int address_id) {
		super();
		AddCategories = addCategories;
		Door_no = door_no;
		StreetName = streetName;
		City = city;
		this.state = state;
		Postalcode = postalcode;
		Country = country;
		this.contact_id = contact_id;
		Address_id = address_id;
	}


	public int getAddress_id() {
		return Address_id;
	}
	public void setAddress_id(int address_id) {
		Address_id = address_id;
	}
	public String getAddCategories() {
		return AddCategories;
	}
	public void setAddCategories(String addCategories) {
		AddCategories = addCategories;
	}
	public String getDoor_no() {
		return Door_no;
	}
	public void setDoor_no(String door_no) {
		Door_no = door_no;
	}
	public String getStreetName() {
		return StreetName;
	}
	public void setStreetName(String streetName) {
		StreetName = streetName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalcode() {
		return Postalcode;
	}
	public void setPostalcode(String postalcode) {
		Postalcode = postalcode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getcontact_id() {
		return contact_id;
	}
	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}
	

}
