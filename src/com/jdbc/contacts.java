package com.jdbc;

public class contacts {
	
	private int contact_id;
	public contacts(int contact_id, String contactNo, String category, String p_id) {
		super();
		this.contact_id = contact_id;
		ContactNo = contactNo;
		Category = category;
		this.p_id = p_id;
	}
	private String ContactNo;
	private String Category;
	private String p_id;
	public contacts(String contactNo, String category, String p_id) {
		super();
		ContactNo = contactNo;
		Category = category;
		this.p_id = p_id;
	}
	

	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
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
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
}
