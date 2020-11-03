package Assignment1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SetBrowserWindowSize {
public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
}
	
	 @Test
	    public void SetSizeWindow() {
	    
	    	Dimension dimen = new Dimension(200,700);
	     	//Resize current window 
	     	driver.manage().window().setSize(dimen);
	    }
	 
	@AfterClass
		public void WebDriverClosure() {
			driver.quit();
		}
}