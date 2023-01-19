package Ecom.Zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewContact {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
		System.out.println("Login Page Displayed");
		else
		System.out.println("Login Page is not Displayed");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::div[@class='inputs']/descendant::input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::div[@class='inputs']/descendant::input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::div[@class='inputs']/descendant::input[@id='submitButton']")).click();
		if(driver.getTitle().equals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"))
		System.out.println("Home Page is Displayed");
		else
		System.out.println("Home Page is not Displayed");
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[contains(text(),'Contacts')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("raghuram");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
