package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test(priority=1,groups="title")
	public void googleTitleTest()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=5,groups="maillink")
	public void mailLinkTest()
	{
		boolean b=driver.findElement(By.linkText("mail")).isDisplayed();
	}
	
	@Test(priority=2,groups="test")
	public void test1()
	{
		System.out.println("In test1");
	}
	
	@Test(priority=3,groups="test")
	public void test2()
	{
		System.out.println("In test2");
	}
	
	@Test(priority=4,groups="test")
	public void test3()
	{
		System.out.println("In test3");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

