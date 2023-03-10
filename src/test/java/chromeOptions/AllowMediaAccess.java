package chromeOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AllowMediaAccess {

	public static void main(String[] args) throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("use-fake-ui-for-media-stream");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://mictests.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("mic-launcher")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
