package UnitTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UT_3 {
  
  	
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(10));
		
  	}
	
	@Test
public void verifyStoremanagementsectionclick()
{
		

		
		System.out.println("Unit Test Case 1");
		System.out.println("This test will check the store section page is operating properly in the Store management section ");
	//when the login button is click after adding the credentials then it will open the store administration page of website 
		driver.findElement(By.xpath("/html/body/ngx-app/div/ngx-auth/nb-layout/div/div/div/div/div/nb-layout-column/ngx-login/div[1]/div/div/div/form/div[4]/button"));
		

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(15));
		String href="http://localhost:82/#/pages/home";
			
		
			driver.navigate().to(href);
			driver.navigate().forward();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(15));
			driver.navigate().refresh();
//Search the Store Management section from the Home page of Store Adminstration 
		driver.findElement(By.xpath("/html/body/ngx-app/div/ngx-pages/ngx-sample-layout/nb-layout/div/div/div/nb-sidebar[1]/div/div/nb-menu/ul/li[3]/a/span"));
		// Searching the button of create Store  and perform click on it which will redirect it to the store page
		WebElement c1=driver.findElement(By.xpath("/html/body/ngx-app/div/ngx-pages/ngx-sample-layout/nb-layout/div/div/div/nb-sidebar[1]/div/div/nb-menu/ul/li[3]/ul/li[3]/a/span"));

driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(15));
c1.click();
String href1="http://localhost:82/#/pages/store-management/create-store";
driver.navigate().to(href1);
driver.navigate().forward();
driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(15));
driver.navigate().refresh();
driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(15));
String newUrl = driver.getCurrentUrl();
System.out.println(newUrl);

//matching with the checkout page url
String expectedUrl="http://localhost:82/#/pages/store-management/create-store";
	Assert.assertEquals(newUrl, expectedUrl );
       System.out.println("URL matched successfully");
}
	@AfterMethod
	public void teardown()
	{

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(15));
		driver.close();
	}
  
  
}
