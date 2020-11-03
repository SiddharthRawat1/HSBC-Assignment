package Assignment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingBootStrapDropDown {
	
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	}

	@Test
	private void bootStrapDropDown() {
		driver.findElement(By.xpath("//span[contains(text(),'HTML, CSS')]")).click();

		List<WebElement> listdrop = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
		
		System.out.println("Size of bootStrap Drop down: " + listdrop.size());

		for (int i = 0; i < listdrop.size(); i++) {
			if (listdrop.get(i).getText().contains("Java")) {
				listdrop.get(i).click();
				break;
			} 
		}
		
			}
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}