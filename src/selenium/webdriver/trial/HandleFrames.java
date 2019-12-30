package selenium.webdriver.trial;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com");

		driver.findElement(By.name("username")).sendKeys("shilpaabc");
		driver.findElement(By.name("password")).sendKeys("Sh$ln9606");
		// WebElement loginbutton=driver.findElement(By.xpath("//input[@type='submit']"));
		// loginbutton.click();--Gives exceptions as
		// ElementNotClickableException:Element not clickable at poing...
		
		//Use below code to handle above exception

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
//		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
//		if (invisible == true) {
//			WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));
//			loginbutton.click();
//
//		}

		//Another way to handle this exception as follows:
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));

		js.executeScript("arguments[0].click()", loginbutton);
		
		//Handle frames using below code---
		driver.switchTo().frame("mainpanel");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
		
	}

}
