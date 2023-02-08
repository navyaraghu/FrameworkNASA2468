package chromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RemovingChromeAutomationMSG {

	public static void main(String[] args) throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.amazon.com");
		Thread.sleep(3000);
		driver.quit();

	}

}
