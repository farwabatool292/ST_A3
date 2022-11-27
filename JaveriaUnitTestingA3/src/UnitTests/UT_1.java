package UnitTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UT_1 {

  static WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		// Basic set up 
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://localhost:82/#/auth");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
  	}
	
	@Test
public void verifyStoremanagementsectionclick()
{
		System.out.println("Unit Test Case 1");
		System.out.println("This test will check the store section page is operating properly in the Store management section ");
		driver.findElement(By.xpath("/html/body/ngx-app/div/ngx-auth/nb-layout/div/div/div/div/div/nb-layout-column/ngx-login/div[1]/div/div/div/form/div[4]/button"));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		
	
		
		String href="http://localhost:82/#/pages/home";
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		
			
		
			driver.navigate().to(href);
			driver.navigate().forward();
			driver.navigate().refresh();
			driver.getCurrentUrl();
			
}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
