package utilityImplementationClasses;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;

public class CreateNewContact {

	public static void main(String[] args) throws InterruptedException 
	{
		PropertiesFileUtility property=new PropertiesFileUtility();
		ExcelUtility excel=new ExcelUtility();
		JavaUtility javautil=new JavaUtility();
		WebDriverUtility web=new WebDriverUtility();
		property.propertyFileInitialization(IConstantPath.PROPERTY_FILE_EPATH);
		excel.excelInitilization(IConstantPath.EXCEL_FILE_PATH);
		String browser=property.fetchProperty("browser");
		String url=property.fetchProperty("url");
		long time=Long.parseLong(property.fetchProperty("timeouts"));
		WebDriver driver=web.openApplication(browser, url, time);
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
		System.out.println("Login Page Displayed");
		else
		System.out.println("Login Page is not Displayed");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::div[@class='inputs']/descendant::input[@name='user_name']")).sendKeys(property.fetchProperty("username"));
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::div[@class='inputs']/descendant::input[@name='user_password']")).sendKeys(property.fetchProperty("password"));
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::div[@class='inputs']/descendant::input[@id='submitButton']")).click();
		if(driver.getTitle().equals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"))
		System.out.println("Home Page is Displayed");
		else
		System.out.println("Home Page is not Displayed");
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[contains(text(),'Contacts')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(2000);
		Map<String,String> map=excel.readDataFromExcel("Create Contact", "TestData");
		
		String lastName=map.get("Last Name")+javautil.generateRandomNumber(100);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(2000);
		driver.quit(); 

	}

}
