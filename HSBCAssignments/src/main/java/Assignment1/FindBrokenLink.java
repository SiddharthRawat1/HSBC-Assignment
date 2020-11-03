package Assignment1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindBrokenLink {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.zlti.com");
}
		@Test
	public void brokenLink() {
		String url="";
	
		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> i = links.iterator();

		while(i.hasNext()){

		url = i.next().getAttribute("href");

		System.out.println(url);

		if(url == null || url.isEmpty()){
		System.out.println("URL is empty : ");
		continue;
	
		}
	}
}
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
