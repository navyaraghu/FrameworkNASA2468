package Ecom.Zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingNewLeadAndDuplicate {

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
		driver.findElement(By.xpath("//td[@class='small']//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("rajguru");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("vatican");
		driver.findElement(By.xpath("//div[@align='center']/input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Duplicate [Alt+U]']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("rajguru1");
		driver.findElement(By.xpath("//div[@align='center']/input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
