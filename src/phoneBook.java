import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class phoneBook {
	static Connection conn;
	static Statement stm = null ;
	static  String FirstName;
	static String LastName;
	static String Email;
	static String Relationship;
	static String Birthday;
	static String ContactNo;
	static String Category;
	static String p_id;
	static String Door_no;
	static String StreetName;
	static String City;
	static String State;
	static String Postalcode;
	static String Country;
	static String contact_id;
	static String Address_id;
	
	
	
	
	
	static void setup()
    {
        try 
        {
            File f= new File("src/connection.properties");
            FileInputStream fis = new FileInputStream(f);
            
            Properties p= new Properties();
            p.load(fis);
            
            String driverName=p.getProperty("driverName");
            String url=p.getProperty("url");
            String user=p.getProperty("user");
            String password=p.getProperty("password");
            
            // load and register the driver
            
            
            Class.forName(driverName); 
            //conn establishing the connection to the database
            
         
            conn = DriverManager.getConnection(url,user,password);  
            //Statement stmt=conn.createStatement();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
        System.out.println("Connection created successfully");
    }

/*------------------------------------------------------------------------------*/	
	
	
	
	//UserInput Method
    static void UserInput()
    {
        Scanner s3=new Scanner(System.in);
        
        boolean flag = true;
        while(flag)
        {
            
            System.out.println("Enter 'I' to Insert data  \nEnter 'V' to view records\nEnter 'U' to Update\nEnter 'R' to Retrieve Data\nEnter 'D' to Delete Data\nEnter  'E' to exit\nEnter your choice " );
            String c=s3.nextLine();
            System.out.println("\n");
            
            if("I".equals(c))
            {
                Insert();
                System.out.println("\n");
            }
           
           else if("U".equals(c))
           {
          	Update();
               System.out.println("\n");
           }
           else if("R".equals(c))
           {
               RetrieveData();
               System.out.println("\n");
           }
           else if("D".equals(c))
           {
               Delete();
               System.out.println("\n");
           }
            
           else if("V".equals(c))
           {
               View();
               System.out.println("\n");
           }
          else   
           {
        	   closeconnection();
        	   System.out.println("connection closed");
        	   flag = false;
        	 System.exit(0);
        	   
           }
            
          
        
    }}
    
 /*---------------------------------------------------------------------------------*/   
    
    
    //Update
    
    static void Update()
    {
        Scanner s4=new Scanner(System.in);
        
        boolean flag = true;
        while(flag)
        {
            
            System.out.println("Enter 'UP' to Update data in people \nEnter 'UC' to Update data in Contacts \nEnter 'UA' to update data into Address\nEnter'USP to update single field in people \nEnter 'S' to start\nEnter  'E' to exit\nEnter your choice " );
            String c=s4.nextLine();
            System.out.println("\n");
            
            if("UP".equals(c))
            {
                UpdatePeople();
                System.out.println("\n");
            }
            else if("UC".equals(c))
            {
            	UpdateContacts();
                System.out.println("\n");
            }
           else if("UA".equals(c))
            {
           	UpdateAddress();
                System.out.println("\n");
            }
           else if("USP".equals(c))
           {
          	UpdateSingleFieldInPeople();
               System.out.println("\n");
           }
           
           else if("S".equals(c))
           {
          	UserInput();
               System.out.println("\n");
           }
            
        
            
            else   
            {
         	   closeconnection();
         	   System.out.println("connection closed");
         	   flag = false;
         	 System.exit(0);
         	   
            }
        
    }}
    
    
    //update people record
    
    private static void UpdatePeople() 
    {
        try 
        {

        	PreparedStatement stm=conn.prepareStatement("update people set FirstName=?,LastName=?,Email=?,Relationship=?,Birthday=? where p_id=?");
            
            
            Scanner s=new Scanner(System.in);
            
            System.out.println("Enter the FirstName: ");
            FirstName=s.nextLine();
            
            System.out.println("Enter the LastName: ");
            LastName=s.nextLine();
            
            System.out.println("Enter the Email: ");
            Email=s.nextLine();
            
            System.out.println("Enter the Relationship: ");
            Relationship=s.nextLine();
            
            System.out.println("Enter the Birthday: ");
            Birthday=s.nextLine();
            
            System.out.println("Enter the p_id");
            p_id = s.nextLine();
            
            stm.setString(1, FirstName);
            stm.setString(2, LastName);
            stm.setString(3, Email);
            stm.setString(4,Relationship);
            stm.setString(5,Birthday);
            
            stm.setString(6, p_id);
            int ResultSet =stm.executeUpdate();
            
            System.out.println(ResultSet+" data inserted \n");  

            stm.close();

            
        } 
        catch (SQLException e)
        {
           System.out.println(e);
        } 
      System.out.println("update people success");  
            
    }
    
   //update contact 
    private static void UpdateContacts() 
    {
        try 
        {

        	PreparedStatement stm=conn.prepareStatement("update contacts set Category=?,ContactNo=? where contact_id=?");
            
            
            Scanner s=new Scanner(System.in);
            
            System.out.println("Enter the Category: ");
            Category=s.nextLine();
            
            System.out.println("Enter the ContactNo: ");
            ContactNo=s.nextLine();
            
            System.out.println("Enter the Contact_id");
            contact_id = s.nextLine();
            
            stm.setString(1, Category);
            stm.setString(2, ContactNo);

            stm.setString(3, contact_id);
            
            int ResultSet =stm.executeUpdate();
            
            System.out.println(ResultSet+" data inserted \n");  

            stm.close();

            
        } 
        catch (SQLException e)
        {
           System.out.println(e);
        } 
      System.out.println("updated contact success");  
            
    }
    
    //Update Address
    private static void UpdateAddress() 
    {
        try 
        {

        	PreparedStatement stm=conn.prepareStatement("update Address set Door_no=?,StreetName=?,City=?,State=?,Postalcode=? where Address_id=?");
            
            
            Scanner s=new Scanner(System.in);
            
            System.out.println("Enter the DoorNO: ");
            Door_no=s.nextLine();
            
            System.out.println("Enter the StreetName: ");
            StreetName=s.nextLine();
            
            System.out.println("Enter the City: ");
            City=s.nextLine();
            
            System.out.println("Enter the State: ");
            State=s.nextLine();
            
            System.out.println("Enter the Postalcode: ");
            Postalcode=s.nextLine();
            
            System.out.println("Enter the Address_id: ");
            Address_id=s.nextLine();
            
            stm.setString(1, Door_no);
            stm.setString(2, StreetName);
            stm.setString(3, City);
            stm.setString(4, State);
            stm.setString(5, Postalcode);
            stm.setString(6, Address_id);
            int ResultSet =stm.executeUpdate();
            
            System.out.println(ResultSet+" data inserted \n");  

            stm.close();

            
        } 
        catch (SQLException e)
        {
           System.out.println(e);
        } 
      System.out.println("update people success");  
            
    }
    
    
    private static void UpdateSingleFieldInPeople() {
    	try
		{
		
		Scanner s=new Scanner(System.in);
   	    System.out.println("Enter the p_id:");
   	    int p_id = Integer.parseInt(s.nextLine());
   	    String query = "select *from people  where p_id = "+p_id;
   	   
   	    Statement stm = conn.createStatement();	
   	    ResultSet rs =stm.executeQuery(query);
   	 
   	 
   	 
   	      
             if(rs.next()) {
            	 int peopleId = rs.getInt("p_id");
            	 String FirstName = rs.getString("FirstName");
            	 String LastName = rs.getString("LastName");
            	 String Email = rs.getString("Email");
            	 String Relationship = rs.getString("Relationship");
            	 String Birthday = rs.getString("Birthday");
            	 
            	 System.out.println("people Id"+p_id);
            	 System.out.println("First Name"+FirstName);
            	 System.out.println("Last Name"+LastName);
            	 System.out.println("Email"+Email);
            	 System.out.println("Relationship"+Relationship);
            	 System.out.println("Birthday"+Birthday);
            	 
            	 System.out.println("What do you want to update");
            	 System.out.println("1.First Name");
            	 System.out.println("2.Last Name");
            	 System.out.println("3.Email");
            	 System.out.println("4.Relationship");
            	 System.out.println("5.Birthday");
            	 
            	 
            	int choice = Integer.parseInt(s.nextLine());
            	String sqlQuery = "update people set ";
            	 
            	 switch(choice) {
            	 case 1:
            		 System.out.println("Enter the new First Name");
            		 String FirstName1 = s.nextLine();
            		 sqlQuery = sqlQuery + "FirstName = ? where p_id = "+p_id;
            	     PreparedStatement preparedstatement = conn.prepareStatement(sqlQuery);
            		 preparedstatement.setString(1, FirstName1);
            		
            	     int rows = preparedstatement.executeUpdate();
            		 if(rows>0) {
            			 System.out.println("record updated");
            		 }
            		 break;
            		 
            	 case 2:
            		 System.out.println("Enter the new Last Name");
            		 String LastName1 = s.nextLine();
            		 sqlQuery = sqlQuery + "LasttName = ? where p_id = "+p_id;
            	     PreparedStatement preparedstatement1 = conn.prepareStatement(sqlQuery);
            		 preparedstatement1.setString(1, LastName1);
            	     int rows1 = preparedstatement1.executeUpdate();
            		 if(rows1>0) {
            			 System.out.println("record updated");
            		 }
            		
            	break;
            	 case 3:
            		 System.out.println("Enter the new Email");
            		 String Email1 = s.nextLine();
            		 sqlQuery = sqlQuery + "Email = ? where p_id = "+p_id;
            	     PreparedStatement preparedstatement2 = conn.prepareStatement(sqlQuery);
            		 preparedstatement2.setString(1, Email1);
            	     int rows2 = preparedstatement2.executeUpdate();
            		 if(rows2>0) {
            			 System.out.println("record updated");
            		 }
            		 break;
            	 case 4:
            		 System.out.println("Enter the new Relationship");
            		 String Relationship1 = s.nextLine();
            		 sqlQuery = sqlQuery + "Relationship = ? where p_id = "+p_id;
            	     PreparedStatement preparedstatement3 = conn.prepareStatement(sqlQuery);
            		 preparedstatement3.setString(1, Relationship1);
            	     int rows3 = preparedstatement3.executeUpdate();
            		 if(rows3>0) {
            			 System.out.println("record updated");
            		 }
            		break;
            	 case 5:
            		 System.out.println("Enter the new Birthday");
            		 String Birthday1 = s.nextLine();
            		 sqlQuery = sqlQuery + "Birthday = ? where p_id = "+p_id;
            	     PreparedStatement preparedstatement4 = conn.prepareStatement(sqlQuery);
            		 preparedstatement4.setString(1, Birthday1);
            	     int rows4 = preparedstatement4.executeUpdate();
            		 if(rows4>0) {
            			 System.out.println("record updated");
            		 }
            		
            	break;
            	default:
            		break;
            	 }
            	 
            	 
             }
             
             else {
            	 System.out.println("records not found");
             }
             stm.close();
		}
		 catch (SQLException e)
        {
           System.out.println(e);
        } 
      
          
    }
/*---------------------------------------------------------------------------------*/ 
    
    
    private static void View()
    {
        Scanner s=new Scanner(System.in);
        
        boolean flag = true;
        while(flag)
        {
            
            System.out.println("Enter 'VA' to View All data   \nEnter 'VSD' to View Single data in Contacts \nEntaet 'S' to start\nEnter  'E' to exit\nEnter your choice " );
            String c=s.nextLine();
            System.out.println("\n");
            
            if("VA".equals(c))
            {
                ViewAll();
                System.out.println("\n");
            }
            else if("VSD".equals(c))
            {
            	ViewSingle();
                System.out.println("\n");
            }
          
            else if("S".equals(c))
            {
           	UserInput();
                System.out.println("\n");
            }
             
         
             
             else   
             {
          	   closeconnection();
          	   System.out.println("connection closed");
          	   flag = false;
          	 System.exit(0);
          	   
             }
         
     }}
     
            
          
        
    
    /*-------------------------------------------------------------------------*/
    // view All datas
    private static void ViewAll()
    {    
        try
        {
        	Statement stm = conn.createStatement();
        	Scanner s=new Scanner(System.in);
        	 System.out.println("Enter the p_id:");
        	 int number = Integer.parseInt(s.nextLine());
            //Create a Statement
          // Statement stm = conn.createStatement();
            String query = ("select  people.p_id,people.FirstName,people.LastName,people.Email,contacts.contactNo,contacts.Category,Address.AddCategories,\r\n"
    		 		+ "Address.Door_no,Address.StreetName,Address.city,Address.State,Address.Postalcode,Address.Country\r\n"
    		 		+ "from people\r\n"
    		 		+ "join contacts on people.p_id=\r\n"
    		 		+ "contacts.p_id\r\n"
    		 		+ "join Address on contacts.contact_id = \r\n"
    		 		+ "Address.contact_id \r\n"
    		 		+ "where people.p_id = "+ number);
    		
    		 //Statement stmt = conn.createStatement();
    		 ResultSet rs = stm.executeQuery(query);
    		 
    		 if(rs.next()) {
    			 
    			 System.out.print(+rs.getInt(1)+",");
       	      System.out.println("First Name: "+rs.getString(2)+", ");
       	      System.out.println("Last Name: "+rs.getString(3)+", ");
       	      System.out.println("Email: "+rs.getString(4)+", ");
       	      System.out.println("contactNo: "+rs.getString(5)+", ");
       	      System.out.println("Category: "+rs.getString(6)+" ,");
       	      System.out.println("AddCategory: "+rs.getString(7)+" ,");
       	      System.out.println("Door_no: "+rs.getString(8)+" ,");
       	      System.out.println("StreetName: "+rs.getString(9)+" ,");
       	      System.out.println("City: "+rs.getString(10)+" ,");
       	      System.out.println("State: "+rs.getString(11)+" ,");
       	      System.out.println("Postalcode: "+rs.getString(12)+" ,");
       	      System.out.print("Country: "+rs.getString(13)+"\n ");
       	   System.out.println("data viewed successfully from all tables");
    			 
    		 }
    		 else {
    			 System.out.println("No Records Found");
    		 }
    		
            stm.close();
            
        }
        catch (SQLException e) 
        {
            System.out.println(e);
            
        }
    }
    //View all fields in single table using joins
    static void ViewSingle()
    {    
        try
        {
            //Create a Statement
            Statement stm = conn.createStatement();
            
            //Execute Query and Get Result set
            ResultSet rs =stm.executeQuery("select  people.FirstName,people.LastName,contacts.contactNo,contacts.Category,Address.city\r\n"
            		+ "from people\r\n"
            		+ "join contacts on people.p_id=\r\n"
            		+ "contacts.p_id\r\n"
            		+ "join Address on contacts.contact_id = \r\n"
            		+ "Address.contact_id \r\n"
            		+ "where contacts.Category='Home'");
            		
            System.out.println("FirstName  LastName   ContactNo   Category     City");
            
            
            //Loop to print each record
            while(rs.next())
            {
                
               // System.out.print(rs.getInt("p_id")+" ");
                System.out.printf("%10s",rs.getString("FirstName")+"    ");
                System.out.printf("%10s",rs.getString("LastName")+"     ");
                System.out.printf("%10s",rs.getString("ContactNo")+"     ");
                System.out.printf("%10s",rs.getString("Category")+"    ");
               System.out.printf("%10s",rs.getString("City")+"   \n  ");
                /*System.out.printf("%10s",rs.getString("contact_id")+"     ");
                System.out.printf("%10s",rs.getString("ContactNo")+" \n    ");
                System.out.print(rs.getInt("contact_id")+"\n ");*/
                
                
                
                
            }
            System.out.println("data viewed successfully from all tables");
            stm.close();
            
        }
        catch (SQLException e) 
        {
            System.out.println(e);
            
        }
    }
      
    /*---------------------------------------------------------------------------------*/    
    
    //Retrieve Data
    
    static void RetrieveData()
    {
        Scanner s=new Scanner(System.in);
        
        boolean flag = true;
        while(flag)
        {
            
            System.out.println("Enter 'RP' to Retrieve data from people \nEnter 'RC' to Retrieve data from Contacts \nEnter 'RA' to Retrieve data from Address \nEnter'RAll' to Retrieve all data from DataBase\nEnter'RPT' to Retrieve all data from DataBase\nEnter  'S' to Start\nEnter your choice " );
            String c=s.nextLine();
            System.out.println("\n");
            
            if("RP".equals(c))
            {
                RetrieveDataFromPeople();
                System.out.println("\n");
            }
            else if("RC".equals(c))
            {
            	RetrieveDataFromContacts();
                System.out.println("\n");
            }
           else if("RA".equals(c))
            {
           	RetrieveDataFromAddress();
                System.out.println("\n");
            }
            
           else if("RALL".equals(c))
           {
          	RetrieveAllData();
               System.out.println("\n");
           }
            
           else if("RPT".equals(c))
           {
        	   ViewByPartialText();
               System.out.println("\n");
           }
           else if("S".equals(c))
           {
          	UserInput();
               System.out.println("\n");
           }
            
        
            
            else   
            {
         	   closeconnection();
         	   System.out.println("connection closed");
         	   flag = false;
         	 System.exit(0);
         	   
            }
        
    }}
    //Retrieve All Data From three tables without join command
    private static void RetrieveAllData()
    {
    	 try
         {
             //Create a Statement
             Statement stm = conn.createStatement();
             
             //Execute Query and Get Result set
             ResultSet rs =stm.executeQuery("select Address_id,FirstName, LastName, Email, Relationship, Birthday,\r\n"
             		+ "ContactNo, Category,\r\n"
             		+ "AddCategories, Door_no, StreetName, City, State, Postalcode, Country from people p,\r\n"
             		+ "contacts c, Address A where p.p_id =c.p_id and\r\n"
             		+ "c.contact_id = A.contact_id;");
             
             System.out.println("Address_id   FirstName    LastName    Email     Relationship     Birthday	ContactNo	Category	AddCategories	 Door_no	 StreetName	 City	 State	 Postalcode	 Country	 ");
             
             
             //Loop to print each record
             while(rs.next())
             {
                 
                 System.out.print(rs.getInt("Address_id")+" ");
                 System.out.printf("%10s",rs.getString("FirstName")+"    ");
                 System.out.printf("%10s",rs.getString("LastName")+"     ");
                 System.out.printf("%10s",rs.getString("Email")+"      ");
                 System.out.printf("%10s",rs.getString("Relationship")+"    ");
                 System.out.printf("%10s",rs.getString("Birthday")+"   ");
                 System.out.printf("%10s",rs.getString("ContactNo")+"    ");
                 System.out.printf("%10s",rs.getString("Category")+"     ");
                 System.out.printf("%10s",rs.getString("AddCategories")+"      ");
                 System.out.printf("%10s",rs.getString("Door_no")+"    ");
                 System.out.printf("%10s",rs.getString("StreetName")+"   ");
                 System.out.printf("%10s",rs.getString("City")+"     ");
                 System.out.printf("%10s",rs.getString("State")+"      ");
                 System.out.printf("%10s",rs.getString("Postalcode")+"    ");
                 System.out.printf("%10s",rs.getString("Country")+"  \n  ");
                 
                 
                 
                 
             }
             System.out.println("data Retreived successfully from All Tables");
             stm.close();
             
         }
         catch (SQLException e) 
         {
             System.out.println(e);
             
         }
     }
    	
    
    
    //Retrieve Data From People
    private static void RetrieveDataFromPeople()
    {    
        try
        {
            //Create a Statement
            Statement stm = conn.createStatement();
            
            //Execute Query and Get Result set
            ResultSet rs =stm.executeQuery("select *from people");
            
            System.out.println("p_id   FirstName    LastName    Email     Relationship     Birthday ");
            
            
            //Loop to print each record
            while(rs.next())
            {
                
                System.out.print(rs.getInt("p_id")+" ");
                System.out.printf("%10s",rs.getString("FirstName")+"    ");
                System.out.printf("%10s",rs.getString("LastName")+"     ");
                System.out.printf("%10s",rs.getString("Email")+"      ");
                System.out.printf("%10s",rs.getString("Relationship")+"    ");
                System.out.printf("%10s",rs.getString("Birthday")+"   \n");
                
                
                
                
            }
            System.out.println("data Retreived successfully from people");
            stm.close();
            
        }
        catch (SQLException e) 
        {
            System.out.println(e);
            
        }
    }

    //Retreieve Data from Contact

    private static void RetrieveDataFromContacts()
    {    
        try
        {
            //Create a Statement
            Statement stm = conn.createStatement();
            
            //Execute Query and Get Result set
            ResultSet rs =stm.executeQuery("select *from contacts");
            
            System.out.println("contact_id   ContactNo Category  p_id ");
            
            
            //Loop to print each record
            while(rs.next())
            {
                
                System.out.print(rs.getInt("contact_id")+" ");
                System.out.printf("%10s",rs.getString("ContactNo")+"    ");
                System.out.printf("%10s",rs.getString("Category")+"     ");
                System.out.print(rs.getInt("p_id")+"\n ");
                
                
                
                
                
            }
            System.out.println("data Retreived successfully from contacts");
            stm.close();
            
        }
        catch (SQLException e) 
        {
            System.out.println(e);
            
        }
    }
// Retrieve Data From Address
    
    private static void RetrieveDataFromAddress()
    {    
        try
        {
            //Create a Statement
            Statement stm = conn.createStatement();
            
            //Execute Query and Get Result set
            ResultSet rs =stm.executeQuery("select *from Address");
            
            System.out.println("Address_id   AddCategories  Door_no  StreetName   City  State   Postalcode  Country  contact_id ");
            
            
            //Loop to print each record
            while(rs.next())
            {
                
                System.out.print(rs.getInt("Address_id")+" ");
                System.out.printf("%10s",rs.getString("AddCategories")+"    ");
                System.out.printf("%10s",rs.getString("Door_no")+"     ");
                System.out.printf("%10s",rs.getString("StreetName")+"     ");
                System.out.printf("%10s",rs.getString("City")+"     ");
                System.out.printf("%10s",rs.getString("State")+"     ");
                System.out.printf("%10s",rs.getString("Postalcode")+"     ");
                System.out.printf("%10s",rs.getString("Country")+"     ");
                System.out.print(rs.getInt("contact_id")+"\n ");
                
                
                
                
            }
            System.out.println("data Retreived successfully from Address");
            stm.close();
            
        }
        catch (SQLException e) 
        {
            System.out.println(e);
            
        }
    }
    
    /*---------------------------------------------------------------------------*/   
    //Reteriving data by partial text
    static void ViewByPartialText()
    {    
        try
        {
        	
        	Scanner s=new Scanner(System.in);
        	System.out.println("Enter the StringToFind: ");
            String StringToFind = s.nextLine();
            
       	    
            Statement stm = conn.createStatement();
            String Sql = ("select  people.p_id,people.FirstName,people.LastName,people.Email,contacts.contactNo,contacts.Category,Address.AddCategories,\r\n"
            		+ "Address.Door_no,Address.StreetName,Address.city,Address.State,Address.Postalcode,Address.Country\r\n"
            		+ "from people\r\n"
            		+ "join contacts on people.p_id=\r\n"
            		+ "contacts.p_id\r\n"
            		+ "join Address on contacts.contact_id = \r\n"
            		+ "Address.contact_id \r\n"
            		+ "where people.FirstName like\r\n"
            		+ StringToFind );
           
         
           
            //Execute Query and Get Result set
            ResultSet rs =stm.executeQuery(Sql);
            		
           // System.out.println("Address_id   FirstName    LastName    Email     Relationship     Birthday	ContactNo	Category	AddCategories	 Door_no	 StreetName	 City	 State	 Postalcode	 Country	");
            
            
            //Loop to print each record
            while(rs.next())
            {
                
               System.out.print(rs.getInt("p_id")+" ");
               System.out.print("First name: "+rs.getString(2)+", ");
        	      System.out.print("Last name: "+rs.getString(3)+", ");
        	      System.out.print("Email: "+rs.getString(4)+", ");
        	      System.out.print("contactNo: "+rs.getString(5)+", ");
        	      System.out.print("Category: "+rs.getString(6)+" ,");
        	      System.out.print("AddCategory: "+rs.getString(7)+" ,");
        	      System.out.print("Door_no: "+rs.getString(8)+" ,");
        	      System.out.print("StreetName: "+rs.getString(9)+" ,");
        	      System.out.print("City: "+rs.getString(10)+" ,");
        	      System.out.print("State: "+rs.getString(11)+" ,");
        	      System.out.print("Postalcode: "+rs.getString(12)+" ,");
        	      System.out.print("Country: "+rs.getString(13)+"\n ");
                
                
                
            }
            System.out.println("data viewed successfully from all tables");
            stm.close();
            
        }
        catch (SQLException e) 
        {
            System.out.println(e);
            
        }
    }
    /*---------------------------------------------------------------------------*/   
    
//Inserting into database
    
    static void Insert()
    {
        Scanner s=new Scanner(System.in);
        
        boolean flag = true;
        while(flag)
        {
            
            System.out.println("Enter 'IP' to Inser data from people \nEnter 'IC' to Insert data from Contacts \nEnter 'IA' to Insert data from Address \nEnter  'S' to Start\nEnter your choice " );
            String c=s.nextLine();
            System.out.println("\n");
            
            if("IP".equals(c))
            {
                InsertingIntopeople();
                System.out.println("\n");
            }
            else if("IC".equals(c))
            {
            	InsertingIntocontacts();
                System.out.println("\n");
            }
           else if("IA".equals(c))
            {
           	InsertingIntoAddress();
                System.out.println("\n");
            }
           else if("S".equals(c))
           {
          	UserInput();
               System.out.println("\n");
           }
            
        
            
            else   
            {
         	   closeconnection();
         	   System.out.println("connection closed");
         	   flag = false;
         	 System.exit(0);
         	   
            }
        
    }}
    
    

    
	
	//inserting data into people
	 private static void InsertingIntopeople()
	    {
	        try 
	        {
	        	PreparedStatement stm=conn.prepareStatement("insert into people(FirstName,LastName,Email,Relationship,Birthday) values(?,?,?,?,?)");
	           
	            
	            Scanner s=new Scanner(System.in);
	            
	            System.out.println("Enter the FirstName: ");
	            FirstName=s.nextLine();
	            
	            System.out.println("Enter the LastName: ");
	            LastName=s.nextLine();
	            
	            System.out.println("Enter the Email: ");
	            Email=s.nextLine();
	            
	            System.out.println("Enter the Relationship");
	            Relationship=s.nextLine();
	            
	            System.out.println("Enter the Date Of Birth:");
	            Birthday=s.nextLine();
	            
	            stm.setString(1, FirstName);
	            stm.setString(2, LastName);
	            stm.setString(3, Email);
	            stm.setString(4, Relationship);
	            stm.setString(5, Birthday);
	            
	            //Get Result set
	           
	            int ResultSet =stm.executeUpdate();
	            
	            System.out.println(ResultSet+" data inserted \n");  

	            stm.close();
	  
	            
	        } 
	        catch (SQLException e)
	        {
	           System.out.println(e);
	        } 
	      System.out.println("success");  
	            
	    }
	 
	 //inserting data into Contacts
	 
	 private static void InsertingIntocontacts()
	    {
	        try 
	        {
	        	PreparedStatement stm=conn.prepareStatement("insert into contacts(ContactNo,Category,p_id) values(?,?,?)");
	           
	            
	            Scanner s1=new Scanner(System.in);
	            
	            System.out.println("Enter the ContactNo: ");
	            ContactNo=s1.nextLine();
	            
	            System.out.println("Enter the Category: ");
	            Category=s1.nextLine();
	            
	            System.out.println("Enter the p_id: ");
	            p_id=s1.nextLine();
	           
	            
	            stm.setString(1, ContactNo);
	            stm.setString(2, Category);
	            stm.setString(3, p_id);
	           
	            //Get Result set
	           
	            int ResultSet =stm.executeUpdate();
	            
	            System.out.println(ResultSet+" data inserted in Contacts  \n");  

	            stm.close();
	  
	            
	        } 
	        catch (SQLException e)
	        {
	           System.out.println(e);
	        } 
	      System.out.println(" contact success");  
	            
	    }
	 
	 
	 //Inserting data into Address table
	 
	 private static void InsertingIntoAddress()
	    {
	        try 
	        {
	        	PreparedStatement stm=conn.prepareStatement("insert into Address(Category,Door_no,StreetName,City,State,Postalcode,Country,p_id) values(?,?,?,?,?,?,?,?)");
	           
	            
	            Scanner s2=new Scanner(System.in);
	            
	            System.out.println("Enter the Category: ");
	            Category=s2.nextLine();
	            
	            System.out.println("Enter the DoorNO: ");
	            Door_no=s2.nextLine();
	            
	            System.out.println("Enter the StreetName: ");
	            StreetName=s2.nextLine();
	            
	            System.out.println("Enter the City: ");
	            City=s2.nextLine();
	            
	            System.out.println("Enter the State: ");
	            State=s2.nextLine();
	            
	            System.out.println("Enter the Postalcode: ");
	            Postalcode=s2.nextLine();
	            
	            System.out.println("Enter the Country: ");
	            Country=s2.nextLine();
	            
	            System.out.println("Enter the p_id: ");
	            p_id=s2.nextLine();
	           
	            
	            stm.setString(1, ContactNo);
	            stm.setString(2, Category);
	            stm.setString(3, p_id);
	           
	            //Get Result set
	           
	            int ResultSet =stm.executeUpdate();
	            
	            System.out.println(ResultSet+" data inserted in Contacts  \n");  

	            stm.close();
	  
	            
	        } 
	        catch (SQLException e)
	        {
	           System.out.println(e);
	        } 
	      System.out.println(" contact success");  
	            
	    }
/*-----------------------------------------------------------------------------*/
	//Delete 
	 
	 static void Delete()
	    {
	        Scanner s=new Scanner(System.in);
	        
	        boolean flag = true;
	        while(flag)
	        {
	            
	            System.out.println("Enter 'DP' to Delete data from people \nEnter 'DC' to Delete data from Contacts \nEnter 'DA' to Delete data from Address \nEnter  'S' to Start\nEnter your choice " );
	            String c=s.nextLine();
	            System.out.println("\n");
	            
	            if("DP".equals(c))
	            {
	                DeletePeople();
	                System.out.println("\n");
	            }
	            else if("DC".equals(c))
	            {
	            	DeleteContacts();
	                System.out.println("\n");
	            }
	           else if("DA".equals(c))
	            {
	           	DeleteAddress();
	                System.out.println("\n");
	            }
	           else if("S".equals(c))
	           {
	          	UserInput();
	               System.out.println("\n");
	           }
	            
	        
	            
	            else   
	            {
	         	   closeconnection();
	         	   System.out.println("connection closed");
	         	   flag = false;
	         	 System.exit(0);
	         	   
	            }
	        
	    }}
	    
	 //delete people
	 private static void DeletePeople() 
	    {
	        try 
	        {

	        	PreparedStatement stm=conn.prepareStatement("delete from people where p_id=?");
	            
	            
	            Scanner s=new Scanner(System.in);
	            
	            System.out.println("Enter the p_id: ");
	            p_id=s.nextLine();
	            
	          
	            
	            stm.setString(1, p_id);
	            
	            int ResultSet =stm.executeUpdate();
	            
	            System.out.println(ResultSet+" data deleted \n");  

	            stm.close();

	            
	        } 
	        catch (SQLException e)
	        {
	           System.out.println(e);
	        } 
	      System.out.println("deleted a record people success");  
	            
	    }
	 
	 //Delete Contact
	 private static void DeleteContacts() 
	    {
	        try 
	        {

	        	PreparedStatement stm=conn.prepareStatement("delete from contacts where contact_id=?");
	            
	            
	            Scanner s=new Scanner(System.in);
	            
	            System.out.println("Enter the contact_id: ");
	            contact_id=s.nextLine();
	            
	          
	            
	            stm.setString(1, contact_id);
	            
	            int ResultSet =stm.executeUpdate();
	            
	            System.out.println(ResultSet+" data deleted \n");  

	            stm.close();

	            
	        } 
	        catch (SQLException e)
	        {
	           System.out.println(e);
	        } 
	      System.out.println("deleted a record people success");  
	            
	    }
	 
	 
	 //Delete Address
	 private static void DeleteAddress()
	 {
	        try 
	        {

	        	PreparedStatement stm=conn.prepareStatement("delete from Address where Address_id=?");
	            
	            
	            Scanner s=new Scanner(System.in);
	            
	            System.out.println("Enter the Address_id: ");
	            Address_id=s.nextLine();
	            
	          
	            
	            stm.setString(1, Address_id);
	            
	            int ResultSet =stm.executeUpdate();
	            
	            System.out.println(ResultSet+" data deleted \n");  

	            stm.close();

	            
	        } 
	        catch (SQLException e)
	        {
	           System.out.println(e);
	        } 
	      System.out.println("deleted a record people success");  
	            
	    }
	 
/*--------------------------------------------------------------------------------*/	    
	 
	 //Close Connection
	 
		private static void closeconnection() {
	    	
		   	 try {
		 			if(stm != null) {
		 				 conn.close();
		 			 }
		 		} catch (SQLException se) {
		 			
		 			//se.printStackTrace();
		 			System.out.println("1");
		 		}
		 		 
		 		 try {
		 			if(conn !=null) {
		 				 conn.close();
		 			 }
		 		} catch (SQLException se) {


		 			//se.printStackTrace();
		 			System.out.println("2");
		 		}
		 		 
			}
	public static void main(String[] args) {
		setup();
		UserInput();
		Update();
		Insert();
		 RetrieveData();
		 ViewByPartialText();
		 View();
		closeconnection();
		

	}

}
