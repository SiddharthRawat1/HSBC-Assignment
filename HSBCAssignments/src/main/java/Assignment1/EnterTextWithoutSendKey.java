package Assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnterTextWithoutSendKey {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() throws FileNotFoundException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//using property to create object
				Properties property = new Properties();
				
				//Call the file MMMT.properties
				FileInputStream objFile = new FileInputStream("D:\\HSBCAssignments\\src\\main\\java\\Assignment1\\PropertiesFile.properties");
				
				//Load property file
				try{
					property.load(objFile);
				}
				catch(IOException e){
					System.out.println(e.getMessage());
					e.printStackTrace();

					driver.get(property.getProperty("jqueryURL"));

		driver.get("googleURL");
	}
	}
	@Test
    public void textWithoutSendkeys() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement search = driver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));
    	
		js.executeScript("arguments[0].value = 'Book'" , search);
    }
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
