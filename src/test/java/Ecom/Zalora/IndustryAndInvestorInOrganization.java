package Ecom.Zalora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IndustryAndInvestorInOrganization {

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
		driver.findElement(By.xpath("//a[contains(text(),'Organizations') and @href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("SquareRC3");
		Select dropdown=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
		dropdown.selectByVisibleText("Education");
		Thread.sleep(2000);
		Select dropdown1=new Select(driver.findElement(By.xpath("//select[@name='accounttype']")));
		dropdown1.selectByVisibleText("Investor");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@align='center']//input[@title='Save [Alt+S]'][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
