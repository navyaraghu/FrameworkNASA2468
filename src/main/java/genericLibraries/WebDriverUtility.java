package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all reusable methods of WebDriver
 * @author DELL
 *
 */
public class WebDriverUtility
{
	
	public WebDriver driver;
	/**
	 * This method is used to launch the Browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) 
	{
		
		switch(browser)
		{
		case "chrome": driver=new ChromeDriver();
		break;
		case "firefox": driver=new FirefoxDriver();
		break;
		case "edge": driver=new EdgeDriver();
		break;
		default: System.out.println("Invalid Browser");
		}
		return driver;
	}
	/**
	 * This methodss is used to maximise the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to navigate to the application
	 * @param url
	 */
	public void navigateToAppliction(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to wait till web page is loaded
	 * @param time
	 */
	public void waitTillPageLoad(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	/**
	 * This method is used to wait until the visibility of WebElement
	 * @param time
	 * @param element
	 */
	public void explicitWait(long time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to mouse hover on an element
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on an element
	 * @param element
	 */
	public void doubleClickonElement(WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This Method is used to right click on an element
	 * @param element
	 */
	public void rightClick(WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is used to double click on an element
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebElement src, WebElement dest)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src,dest).perform();
	}
	/**
	 * This method is used to select an element from drop down based on the value
	 * @param element
	 * @param value
	 */
	
	public void dropdown(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select an element from drop down based on the index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select an element from drop down based on the text
	 * @param text
	 * @param element
	 */
	public void dropdown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to get parent window ID
	 * @return
	 */
	public String getParentWindowID() {
		return driver.getWindowHandle();
	}
	/**
	 * This method is used to handle child browser pop up
	 */
	public void childBrowserPopup() {
		Set<String> set=driver.getWindowHandles();
		for(String window:set)
		{
			driver.switchTo().window(window);
		}
	}
	/**
	 * This method is used to switch to frame based on index
	 * @param index
	 */
	public void switchToFrame(String index) {
	driver.switchTo().frame(index);
		
	}
	/**
	 * This method is used to switch to frame based on element
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);	
	}
	/**
	 * This method is used accept the alert
	 */
	public void alertAccept() {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to cancel the alert
	 */
	public void alertCancel() {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to disable the notifications
	 * @return
	 */
	public ChromeOptions disableNotification() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;
	}
	/**
	 * This method is used to fetch the screenshot of the web page in file
	 * @param javaUtil
	 * @param classname
	 * @return
	 */
	public String getScreenshot(JavaUtility javaUtil, String classname) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		String currentTime=javaUtil.getCurrentTime();
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/"+classname+"_"+currentTime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	/**
	 * This method is used to fetch the screen shot based on Base64 format
	 * @return
	 */
	public String getScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	/**
	 * This method is used to scroll the page till the WebElement
	 * @param element
	 */
	public void scroolTillElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	/**
	 * This method is used to close the current window
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	/**
	 * This method is used to close all the windows and exit the browser
	 */
	public void closeWindows() {
		driver.quit();
	}
	/**
	 * This method launches browser, maximizes it, navigates to application and also provides implicit wait
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */
	public WebDriver openApplication(String browser, String url, long time) {
		driver=launchBrowser(browser);
		maximizeBrowser();
		navigateToAppliction(url);
		waitTillPageLoad(time);
		return driver;
	}
}
