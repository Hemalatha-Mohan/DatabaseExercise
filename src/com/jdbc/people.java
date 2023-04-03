package com.jdbc;

public class people {

	private int p_id;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Relationship;
	private String Birthday;
	
	
	public people(String firstName, String lastName, String email, String relationship, String birthday) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Relationship = relationship;
		Birthday = birthday;
	}
	
	public people(int p_id, String firstName, String lastName, String email, String relationship, String birthday) {
		super();
		this.p_id = p_id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Relationship = relationship;
		Birthday = birthday;
	}
	public int getp_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
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
	
	
	
}
