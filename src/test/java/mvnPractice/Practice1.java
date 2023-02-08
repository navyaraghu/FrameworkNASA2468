package mvnPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice1 {
@Test
public void demoTest1()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.quit();
}

}
