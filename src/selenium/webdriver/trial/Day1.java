package selenium.webdriver.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1 {

	
	WebDriver driver;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.get("https://www.edureka.co");
			
			Login();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		public void Login()
		{
		   try {
			driver.findElement(By.linkText("Log In")).click();
			//driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("khandge_shilpa@yahoo.com");
			WebDriverWait wait=new WebDriverWait(driver,10);
			WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("si_popup_email")));
			emailField.sendKeys("khandge_shilpa@yahoo.com");
			//driver.findElement(By.id("si_popup_email")).sendKeys("khandge_shilpa@yahoo.com");
			driver.findElement(By.id("si_popup_passwd")).sendKeys("S@P@k1982");
        	driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    }
	public static void main(String[] args) {

		Day1 myobj = new Day1();
		
		myobj.invokeBrowser();
		//myobj.Login();
	}
	}


