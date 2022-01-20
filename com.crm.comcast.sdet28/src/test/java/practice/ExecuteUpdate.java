package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {

	public static void main(String[] args) throws SQLException 
	{
		Connection connection2=null;
		try {
			//Register the driver
			
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			//Establish the database connection
			
			connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
			
			//issue statement
			
			Statement statement2 = connection2.createStatement();
			
			//execute querry
			int result = statement2.executeUpdate("insert into student values(104, 'Tom', 'computer');");
			if(result==1)
			{
				System.out.println("Database has been updated");
			}
			else
			{
				System.out.println("Database has not been updated");
			}
			
			
			
			
		} catch (Exception e)
		{
			
		}
			
	
	finally
	{
		//close the database connection
				connection2.close();
				System.out.println("program is executed");
		
	}
		
		
		
		
		
		 

	}

}
