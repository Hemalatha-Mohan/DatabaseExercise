package com.jdbc;

public class AllData {
	
	
	
	private int Address_id;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Relationship;
	private String Birthday;
	private String ContactNo;
	private String Category;
	private String AddCategories;
	private String Door_no;
	private String StreetName;
	private String City;
	private String state;
	private String Postalcode;
	private String Country;
	
	
	public AllData(String firstName, String lastName, String email, String relationship, String birthday,
			String contactNo, String category, String addCategories, String door_no, String streetName, String city,
			String state, String postalcode, String country) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Relationship = relationship;
		Birthday = birthday;
		ContactNo = contactNo;
		Category = category;
		AddCategories = addCategories;
		Door_no = door_no;
		StreetName = streetName;
		City = city;
		this.state = state;
		Postalcode = postalcode;
		Country = country;
	}
	
	
	public AllData(int address_id, String firstName, String lastName, String email, String relationship,
			String birthday, String contactNo, String category, String addCategories, String door_no, String streetName,
			String city, String state, String postalcode, String country) {
		super();
		Address_id = address_id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Relationship = relationship;
		Birthday = birthday;
		ContactNo = contactNo;
		Category = category;
		AddCategories = addCategories;
		Door_no = door_no;
		StreetName = streetName;
		City = city;
		this.state = state;
		Postalcode = postalcode;
		Country = country;
	}


	public int getAddress_id() {
		return Address_id;
	}
	public void setAddress_id(int address_id) {
		Address_id = address_id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getRelationship() {
		return Relationship;
	}
	public void setRelationship(String relationship) {
		Relationship = relationship;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
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
	
	

	
	
	

	
	
	
}
