package jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {

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
		ResultSet result=statement.executeQuery("select * from students;");
		
		while(result.next()) 
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		//step6:close the database
		connect.close();
		
		

	}

}
