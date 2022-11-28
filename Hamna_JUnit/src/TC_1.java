package TCPackage_1;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TC_1 {
	  WebDriver driver;
			@BeforeMethod
			public void setUp()
			{ 
				 System.setProperty("webdriver.chrome.driver", "E:\\7th sem\\SE\\chromedriver.exe");
			driver = new ChromeDriver();
			///implicitly wait before going to url
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://localhost/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			///maximizing the window
			driver.manage().window().maximize();

			}
			@Test
			public void verify_title()
			{
				System.out.println("Test case 1");
				System.out.println("Verify title test case");
				
				//opening the main page
				String href="http://localhost/";	
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
				driver.navigate().to(href);
				driver.navigate().forward();  
				driver.navigate().refresh();
				
				
				//getting title and check it
				String title=driver.getTitle();
				System.out.println("Title is:"+title);
				
				//match it wit the existing title.
				String expected_title="Default store";
				Assert.assertEquals(title, expected_title);
				System.out.println("Test completes");
			}
			
			
			
			@AfterMethod
			public void tearDown()
			{ 
				driver.quit();
				}
}