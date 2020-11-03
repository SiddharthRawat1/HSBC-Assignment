package Assignment2and3;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendReport {
	public static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}

	@Test
	public void extentReportsDemo() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		if (driver.getTitle().equals("Google")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
			System.out.println("Extent Report successfully generated ");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}