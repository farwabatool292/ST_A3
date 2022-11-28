import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TC_3 {
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
				System.out.println("Test case 3");
				System.out.println("Verify title test case");
				
				//opening the main page
				String href="http://localhost/";	
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
				driver.navigate().to(href);
				driver.navigate().forward();  
				driver.navigate().refresh();
				//finding that weather it is present on page or not
				driver.findElement(By.xpath("//div[contains(@class,'col-xl-8 col-lg-8 d-none d-lg-block')]//a[normalize-space()='Tables']"));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
				driver.navigate().refresh();//refreshing the page
				
				//click and go to the next page
				System.out.println("going too the chair page");
				String href1="http://localhost/category/chairs";	
				driver.navigate().to(href1);
				//giving xpath to ensure it is present on page or not
				driver.findElement(By.xpath("//a[@href='/product/chair']//img[@class='default-img']"));
				//set timer for 5 mints and refresh the page
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
				driver.navigate().refresh();
				//comparing the urls
				String URL = driver.getCurrentUrl();
				System.out.println(URL);
				//if it matches then return true
				Assert.assertEquals(URL, "http://localhost/category/chairs" );
				System.out.println("test case successful run");	
				
			}
			
			
			
			@AfterMethod
			public void tearDown()
			{ 
				//closing the file
				driver.quit();
				}
}
