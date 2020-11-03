package Assignment1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchWebPage {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
}
	@Test
	public void GoogleSearch() throws InterruptedException {
    	
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("covid");
    	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	List<WebElement> suggestedList= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
    	System.out.println("List of Suggestion : " + suggestedList.size());
    	
    	for(int i =0; i<suggestedList.size(); i++) {
    		System.out.println(suggestedList.get(i).getText());
    		if (suggestedList.get(i).getText().contains("iphone xr")) {
    			suggestedList.get(i).click();
				
				break;
			   	
    			} 
    	}
	}
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
