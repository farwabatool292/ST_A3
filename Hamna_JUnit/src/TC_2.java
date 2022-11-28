package TCPackage_1;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TC_2 {
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
				System.out.println("Test case 2");
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
				System.out.println("going too the table page");
				String href1="http://localhost/category/tables";	
				driver.navigate().to(href1);
				//giving xpath to ensure it is present on page or not
				driver.findElement(By.xpath("//body/div[@id='root']/div[contains(@class,'shop-area pt-95 pb-100')]/div[contains(@class,'container')]/div[contains(@class,'row')]/div[contains(@class,'col-lg-9 order-1 order-lg-2')]/div[contains(@class,'shop-bottom-area mt-35')]/div[contains(@class,'row grid three-column')]/div[contains(@class,'col-xl-4 col-sm-6')]/div[contains(@class,'product-wrap mb-25')]/div[contains(@class,'product-img')]/a[1]"));
				//set timer for 5 mints and refresh the page
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
				driver.navigate().refresh();
				//comparing the urls
				String URL = driver.getCurrentUrl();
				System.out.println(URL);
				//if it matches then return true
				Assert.assertEquals(URL, "http://localhost/category/tables" );
				System.out.println("test case successful run");	
				
			}
			
			
			
			@AfterMethod
			public void tearDown()
			{ 
				//closing the file
				driver.quit();
				}
}