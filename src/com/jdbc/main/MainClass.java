package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.Address;
import com.jdbc.contacts;
import com.jdbc.people;
import com.jdbc.funtions.DatabaseFunctions;

public class MainClass {
	
	
	static void userInputPeople() {
		

		DatabaseFunctions databaseFunctions = new DatabaseFunctions();
		
		try(Scanner scanner = new Scanner(System.in)){
			
			boolean isRunning = true;
			
			while(isRunning) {
				System.out.println("Enter your choice:");
			   	 System.out.println("1.Insert people");
			   	 System.out.println("2.Insert Contacts");
			   	 System.out.println("3.Insert Address");
			   	 System.out.println("4.Retrieve People ");
			   	 System.out.println("5.Retrieve All");
			   	 System.out.println("6.Retrieve Contacts");
			   	System.out.println("7. Exit");
			   	 
			   	 int choice = Integer.parseInt(scanner.nextLine());
			   	 
			   	 switch (choice) {
			   	 
			   	 case 1:
			   		 System.out.println("Enter FirstName, LastName, Email, Relationship, Birthday ");

			   		databaseFunctions.insertpeople(new people(scanner.nextLine(), scanner.nextLine(), 
			   				scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
			   		 break;
			   		 
			   	case 2:
			  		 System.out.println("Enter ContactNo, Category, p_id");
			  		databaseFunctions.insertcontacts(new contacts(scanner.nextLine(), scanner.nextLine(), 
			   				scanner.nextLine()));
			  		 break;
			  		 
				case 3:
			 		 System.out.println("Enter AddCategory,Door_no,StreetName,City,State,Postalcode,Country,contact_id");
			 		 databaseFunctions.insertAddress(new Address(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),
			 				scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine()));
			 		 break;
			 		 
				case 4:
			 		 databaseFunctions.getAllDatafrompeople();
			 		 break;
			 		 
				case 5:
			 		 databaseFunctions.getAllData();
			 		 break;
			 		 
				case 6:
			 		 databaseFunctions.getAllDatafromcontacts();
			 		 break;
				/*case 7:
			 		 databaseFunctions.getSpecificData();
			 		 break;*/
				case 7:
					System.out.println("Connection closed");
					isRunning = false;
					break;
			 		 
			 	default:
			 		System.out.println(choice);
					 break;
			 		
			   		 
			   	 }
			}
		
		}
   	 catch(Exception e) {
   		 throw new RuntimeException("Something went wrong"+e);
   	 }

	
		
	}
     
	static void UserInputcontacts() {
		
	}
	public static void main(String[] args) {
		
		userInputPeople();
		

	}}
