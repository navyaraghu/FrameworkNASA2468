package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserParallelTest {
	WebDriver driver;
	@Parameters("Browser")
	@BeforeMethod
	public void methodConfiguration(String Browser) throws MalformedURLException 
	{
		URL url=new URL("http://192.168.116.1:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		if(Browser.equals("chrome"))
			cap.setBrowserName("chrome");
		else if(Browser.equals("firefox"))
			cap.setBrowserName("firefox");
		driver=new RemoteWebDriver(url,cap);
		driver.manage().window().maximize();	
	}
	@Test
	public void test() {
		driver.get("https://www.amazon.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
