package crossBrowserParallelExecution;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SwiggyTest
{
	@Parameters("Browser")
	@Test
	public void demoTest(String Browser) {
		WebDriver driver=null;
		switch(Browser) {
		case "chrome": driver= new ChromeDriver();break;
		case "firefox": driver= new FirefoxDriver();break;
		case "edge": driver= new EdgeDriver();break;
		default:System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
	}
}
