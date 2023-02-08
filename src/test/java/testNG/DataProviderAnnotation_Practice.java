package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotation_Practice 
{
@Test(dataProvider="getData")
public void dataProvider(String username, String password)
{
	System.out.println("name= "+username+" password= "+password);
}
@DataProvider
public Object[][] getData() {
	Object[][] obj=new Object[3][2];
	obj[0][0]="raghu1";
	obj[0][1]="123";
	
	obj[1][0]="raghu2";
	obj[1][1]="1234";
	
	obj[2][0]="raghu3";
	obj[2][1]="12345";
	return obj;
}
}
