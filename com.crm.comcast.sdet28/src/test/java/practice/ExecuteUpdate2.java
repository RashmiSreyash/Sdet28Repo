package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate2 {

	public static void main(String[] args) throws SQLException
	{
		Driver driverref2 = new Driver();
		DriverManager.registerDriver(driverref2);
		
		
		
		Connection connection3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
		
		
		Statement statement3 = connection3.createStatement();
		
		int result2 = statement3.executeUpdate("delete from student where sno=102");
		if(result2==1)
		{
			System.out.println("Database has been deleted");
			
		}
		else
		{
			System.out.println("Database has not been deleted");
		}
		
		connection3.close();
		

	}

}
