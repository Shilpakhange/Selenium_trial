package selenium.webdriver.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitwaitConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Shilpa Khandge\\\\Downloads\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		//driver.findElement(By.xpath("//input[@id='u_0_a']")).click();
		//Calling to the clickon method
		
		clickOn(driver,driver.findElement(By.xpath("//input[@id='u_0_a']")),20);
		Thread.sleep(3000);
		
		//Navigate back to click on below mentioned link--
		//driver.navigate().back();
		
		//driver.findElement(By.linkText("Create a Page"));
		clickOn(driver,driver.findElement(By.name("login")),5);
		clickOn(driver,driver.findElement(By.linkText("Recover Your Account")),5);

	}

	//click on method using Explicit wait defined and can be used for any buttons,links,radio-buttons etc.in the program..
	public static void clickOn(WebDriver driver,WebElement locator,int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		
		locator.click();
	}
}
