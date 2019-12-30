package selenium.webdriver.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Yahoosearch {
	WebDriver driver;

	public void invokeBrowser() {

		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			driver.get("https://in.yahoo.com");

			// yahooSearchtest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yahooSearchtest() {
		try {
			// driver.findElement(By.id("uh-search-box")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement searchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uh-search-box")));
			searchbox.sendKeys("Selenium");
			// driver.findElement(By.id("uh-search-box")).sendKeys("Selenium");
			driver.findElement(By.id("uh-search-button")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Yahoosearch obj = new Yahoosearch();
		obj.invokeBrowser();
		obj.yahooSearchtest();

	}

}
