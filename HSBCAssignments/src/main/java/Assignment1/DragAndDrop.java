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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DragAndDrop {
	
	public static WebDriver driver;

	@BeforeClass
	
	public void drag() throws FileNotFoundException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//using property to create object
		Properties property = new Properties();
		
		//Call the file properties file
		FileInputStream objFile = new FileInputStream("D:\\HSBCAssignments\\src\\main\\java\\Assignment1\\PropertiesFile.properties");
		
		//Load property file
		try{
			property.load(objFile);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();

			driver.get(property.getProperty("jqueryURL"));
	}
	}
	
	@Test
	public void DropDown() {
		
		//Scrolling down of Page
		JavascriptExecutor js = (JavascriptExecutor) driver;
 		js.executeScript("window.scrollBy(0,200)");
 		
 		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
 		
 		//Element to drag.    		
        WebElement From=driver.findElement(By.xpath("//*[@id='draggable']"));		      	
         
        //Element to drop.		
        WebElement toElement=driver.findElement(By.xpath("//*[@id='droppable']"));					
         		
        //Using Action class for drag and drop.		
        Actions a=new Actions(driver);

        //Dragged and dropped.		
        a.dragAndDrop(From, toElement).build().perform();	
        
        System.out.println("Drag and drop successfully performed"); 
    
        	}
	
	@AfterClass
	public void WebDriverClosure() {
	driver.quit();
	}

}