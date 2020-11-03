package Assignment1;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingWindow {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://popuptest.com/goodpopups.html");

	}

	@Test
	public void WindowHandle() throws InterruptedException {

		driver.findElement(By.xpath("//a[@href='http://www.popuptest.com/popup3.html']")).click();

		Thread.sleep(2000);

		// for two window handling main window n popup window

		String parent_window = driver.getWindowHandle();
		System.out.println("Before Swiching Title is =" + driver.getTitle());
		Set<String> childWindow = driver.getWindowHandles();
		//Iterator<String> i = childWindow.iterator();
		for (String handle : childWindow) {
			if (!parent_window.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				System.out.println("Child Window Title: " + driver.getTitle());
				driver.close();
				driver.switchTo().window(parent_window);
				System.out.println("Parent Window Title: " + driver.getTitle());

			}
			
		}

	}
}