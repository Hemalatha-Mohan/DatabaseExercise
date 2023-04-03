package com.jdbc.connection;

public class DatabaseQuery {
	
	public static String insertpeopleQuery() {
		
		return "insert into people(FirstName,LastName,Email,Relationship,Birthday) values(?,?,?,?,?)";
		
	}
	public static String insertContactsQuery() {
		return "insert into contacts(ContactNo,Category,p_id) values(?,?,?)";
	}
	
	public static String insertAddressQuery() {
		return "insert into Address(AddCategories,Door_no,StreetName,City,State,Postalcode,Country,contact_id) values(?,?,?,?,?,?,?,?)";
	}
	
	public static String getAllDatafromPeople() {
		return "select * from people ";
	}
	
	public static String SelectAllData() {
		return"select Address_id,FirstName, LastName, Email, Relationship, Birthday,\r\n"
				+ "ContactNo, Category,\r\n"
				+ "AddCategories, Door_no, StreetName, City, State, Postalcode, Country from people p,\r\n"
				+ "contacts c, Address A where p.p_id =c.p_id and\r\n"
				+ "c.contact_id = A.contact_id;";
	}
	
	public static String getAllDatafromcontacts() {
		return "select * from contacts ";
	}
	
	/*public static String getSpecificData() {
		return"select  people.p_id,people.FirstName,people.LastName,people.Email,contacts.contactNo,contacts.Category,Address.AddCategories,\r\n"
				+ "Address.Door_no,Address.StreetName,Address.city,Address.State,Address.Postalcode,Address.Country\r\n"
				+ "from people\r\n"
				+ "join contacts on people.p_id=\r\n"
				+ "contacts.p_id\r\n"
				+ "join Address on contacts.contact_id = \r\n"
				+ "Address.contact_id \r\n"
				+ "where people.p_id = "+number;
				
	}*/
}
