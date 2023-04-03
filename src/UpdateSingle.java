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

public class UpdateSingle {
	
	static Connection conn;
	static Statement stm = null ;
	static int p_id;
	static String FirstName;
	//private static String newLastName;
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
	
	private static void  updateRecord() throws SQLException
	
	{
		
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
		
public static void main(String[] args) throws SQLException {
	setup();
	updateRecord();
	

	}

}
