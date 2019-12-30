package parameterTestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
WebDriver driver;
	@Test
	@Parameters({"url","emailID","password"})
	public void yahoologintest(String url,String emailid,String password) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("login-username")).sendKeys(emailid);
		driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.id("login-passwd")).sendKeys(password);
	}
}
