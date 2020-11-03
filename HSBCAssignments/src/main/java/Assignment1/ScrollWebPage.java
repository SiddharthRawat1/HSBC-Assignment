package Assignment1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollWebPage {
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
}
	
	@Test
	public void ScrollScript() {
		  
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
    }
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}