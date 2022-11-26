package junit_A3;
import org.openqa.selenium.By;

import java.time.Duration;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TC1 {
	  WebDriver driver;
			@BeforeMethod
			public void setUp()
			{ 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Farwa\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			///implicitly wait before going to url
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			///going to respective url
			driver.get("http://localhost/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			///maximizing the window
			driver.manage().window().maximize();

			}
			@Test
			public void verify()
			{
				////define test case
			System.out.println("Unit Test case 1");
			System.out.println("Checking User List button in user management section is working correctly or not");
			///after putting user name and password then pressing login button
			driver.findElement(By.xpath("/html/body/ngx-app/div/ngx-auth/nb-layout/div/div/div/div/div/nb-layout-column/ngx-login/div[1]/div/div/div/form/div[4]/button"));
			//moving to the element define in xpath and clicking on it automatically
			///reference of home page after directing to the 
			String href="http://localhost:82/#/pages/home";	
			driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
			///moving to the home page refernce
			driver.navigate().to(href);
			driver.navigate().forward();  
			driver.navigate().refresh();
			///Finding and clicking on user management button 
			System.out.println("Finding and clicking on User Management Button\\r\\n");
			
			driver.findElement(By.xpath("/html/body/ngx-app/div/ngx-pages/ngx-sample-layout/nb-layout/div/div/div/nb-sidebar[1]/div/div/nb-menu/ul/li[2]/a/span"));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
			driver.navigate().refresh();
			//finding and clicking on user list button

			System.out.println("Finding and clicking on User list Button");
			driver.findElement(By.xpath("/html/body/ngx-app/div/ngx-pages/ngx-sample-layout/nb-layout/div/div/div/nb-sidebar[1]/div/div/nb-menu/ul/li[2]/ul/li[3]/a/span"));		
			//moving to the element define in xpath and clicking on it automatically
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
			driver.navigate().refresh();
			//getting Current URL of the current page
			String newUrl = driver.getCurrentUrl();
			System.out.println(newUrl);
			//matching with the checkout page url
				Assert.assertEquals(newUrl, "http://localhost:82/#/pages/user-management/users" );
			       System.out.println("URL matched successfully");		
			    

			}
			
			
			
			@AfterMethod
			public void tearDown()
			{ 
				}
}
