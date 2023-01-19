package jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WritingDataIntoDatabase {

	public static void main(String[] args) throws SQLException 
	{
		//Step1:Create an instance for JDBC driver
				//Driver should be imported from com.mysql.cj.jdbc.driver
				//new Driver() throws SQLException
				Driver dbDriver=new Driver();
				
				//step2: register to the dbDriver
				//DriverManager is in java.sql.package
				DriverManager.registerDriver(dbDriver);
				
				//Step3: Establish database connection
				//connection should be imported from java.sql Package
				Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root","root");
				
				//step4: Create statement
				//statements should be imported from java.sql package
				Statement statement=connect.createStatement();
				
				//Execute query to fetch data
				int result=statement.executeUpdate("insert into students(id,name,address) values(102,'xyz','Hyderabad');");
				
				if (result==1)
				{
					System.out.println("DB updated succesfully");
				}
				else {
					System.out.println("DB not Updated");
				}
				//step6:close the database
				connect.close();

	}

}
