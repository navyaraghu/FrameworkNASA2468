package ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--Incognito");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.yatra.com");
		Thread.sleep(2000);
		driver.quit();


	}

}
