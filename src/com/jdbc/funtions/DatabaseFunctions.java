package com.jdbc.funtions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.Address;
import com.jdbc.AllData;
import com.jdbc.contacts;
import com.jdbc.people;
import com.jdbc.connection.DatabaseConnection;
import com.jdbc.connection.DatabaseQuery;

public class DatabaseFunctions {
	
	static DatabaseConnection databaseConnection = new DatabaseConnection();
	//private String FirstName;
	
	public void insertpeople(people p) throws SQLException {
		try(Connection conn = databaseConnection.getConnection();
				
				PreparedStatement prestm = conn.prepareStatement(DatabaseQuery.insertpeopleQuery())){
			
			    prestm.setString(1, p.getFirstName());
			    prestm.setString(2, p.getLastName());
			    prestm.setString(3, p.getEmail());
			    prestm.setString(4, p.getRelationship());
			    prestm.setString(5, p.getBirthday());
			    
			    int rows = prestm.executeUpdate();
			    
			    if(rows>0) {
			    	System.out.println("Record Inserted Successfully");
			    }
			    
			    else {
			    	System.out.println("Insert Record Failed");
			    }
				
			
		}
		
	}//End of insert people
 
	public void insertcontacts(contacts c)throws SQLException {
		
		try(Connection conn = databaseConnection.getConnection();
				PreparedStatement prestm = conn.prepareStatement(DatabaseQuery.insertContactsQuery());){
			
			prestm.setString(1, c.getContactNo());
			prestm.setString(2, c.getCategory());
			prestm.setString(3, c.getP_id());
			
			 int rows = prestm.executeUpdate();
			    
			    if(rows>0) {
			    	System.out.println("Record Inserted Successfully");
			    }
			    
			    else {
			    	System.out.println("Insert Record Failed");
			    }
				
					
				}
		
	}
	
public void insertAddress(Address A) throws SQLException {
		
		try(Connection conn = databaseConnection.getConnection();
				PreparedStatement prestm = conn.prepareStatement(DatabaseQuery.insertAddressQuery());){
			
			prestm.setString(1, A.getAddCategories());
			prestm.setString(2, A.getDoor_no());
			prestm.setString(3, A.getStreetName());
			prestm.setString(4, A.getCity());
			prestm.setString(5, A.getState());
			prestm.setString(6, A.getPostalcode());
			prestm.setString(7, A.getCountry());
			prestm.setString(8, A.getcontact_id());
			
			 int rows = prestm.executeUpdate();
			    
			    if(rows>0) {
			    	System.out.println("Record Inserted Successfully");
			    }
			    
			    else {
			    	System.out.println("Insert Record Failed");
			    }
				
					
				}
			
		}//End of insert address 


	public void getAllDatafrompeople() throws SQLException {
		try(Connection conn = databaseConnection.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(DatabaseQuery.getAllDatafromPeople());){
			 System.out.println("p_id   FirstName    LastName    Email     Relationship     Birthday ");
			while(rs.next()) {
				printpeople(new people(
						
		                
						rs.getInt("p_id"),
						rs.getString("FirstName"),
						rs.getString("Lastname"),
						rs.getString("Email"),
						rs.getString("Relationship"),
						rs.getString("Birthday")
						));
			}
			 
		}
		
				
	}//end of get All datas from people
	
	private void printpeople(people p) {
		System.out.println("p_id"+p.getp_id());
		System.out.println("Firstname"+p.getFirstName());
		System.out.println("LastName"+p.getLastName());
		System.out.println("Email"+p.getEmail());
		System.out.println("Relationship"+p.getRelationship());
		System.out.println("Birthday"+p.getBirthday());
		
			
	}
	
	public void getAllData() throws SQLException {
		try(Connection conn = databaseConnection.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(DatabaseQuery.SelectAllData());){
				//System.out.println("Address_id   FirstName    LastName    Email     Relationship     Birthday	ContactNo	Category	AddCategories	 Door_no	 StreetName	 City	 State	 Postalcode	 Country");
			    
				while(rs.next()) {
					
					printAllData(new AllData(rs.getInt("Address_id"),
							rs.getString("FirstName"),
							rs.getString("LastName"),
							rs.getString("Email"),
							rs.getString("Relationship"),
							rs.getString("Birthday"),
							rs.getString("ContactNo"),
							rs.getString("Category"),
							rs.getString("AddCategories"),
							rs.getString("Door_no"),
							rs.getString("StreetName"),
							rs.getString("City"),
							rs.getString("State"),
							rs.getString("Postalcode"),
							rs.getString("Country")
	                 
							
							));
				}
				
		
		
		}
		
		
	}//End of all data 
	
	private void printAllData(AllData al) {
		System.out.print("Address_id:"+al.getAddress_id());
		System.out.printf("\tFirstName:"+al.getFirstName());
		System.out.printf("\tLastName:"+al.getLastName());
		System.out.printf("\tEmail:"+al.getEmail());
		System.out.printf("\tRelationship:"+al.getRelationship());
		System.out.printf("\tBirthday:"+al.getBirthday());
		
		System.out.printf("\tContactNo:"+al.getContactNo());
		System.out.printf("\tCaterory:"+al.getCategory());
		System.out.printf("\tAddCategories:"+al.getAddCategories());
		System.out.printf("\tDoor_no:"+al.getDoor_no());
		System.out.printf("\tStreetName:"+al.getStreetName());
		System.out.printf("\tCity:"+al.getCity());
		System.out.printf("\tState:"+al.getState());
		System.out.printf("\tPostalCode:"+al.getPostalcode());
		System.out.print("\tCountry:"+al.getCountry());
		System.out.println("\n");
	}
	
	public void getAllDatafromcontacts() throws SQLException {
		try(Connection conn = databaseConnection.getConnection();
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(DatabaseQuery.getAllDatafromcontacts());){
			 
			while(rs.next()) {
				printcontacts(new contacts(
						
		                
						//rs.getInt("contact_id"),
						rs.getString("ContactNo"),
						rs.getString("Category"),
						rs.getString("p_id")
						
						));
			}
			 
		}
		
				
	}//end of get All datas from contacts
	
	private void printcontacts(contacts c) {
		
		System.out.print("ContactNo:"+c.getContactNo());
		System.out.printf("\t Category:"+c.getCategory());
		System.out.printf("\t p_id:"+c.getP_id());
		System.out.println("\n");
		
			
	}
	
	/*public void getSpecificData() throws SQLException {
		try(Connection conn = databaseConnection.getConnection();
				Statement statement = conn.createStatement();
				Scanner s=new Scanner(System.in);
	        	 System.out.println("Enter the p_id:");){
	
	
}
}//end of Specific data*/
	


}