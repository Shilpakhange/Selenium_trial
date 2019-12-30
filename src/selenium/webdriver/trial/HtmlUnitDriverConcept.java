package selenium.webdriver.trial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

	//To use HtmlUntDriver concept, we need to import htmlunitdriver jar file.
	//HtmlUnitDriver is not available in selenium 3.x version.
		
		WebDriver driver = new HtmlUnitDriver();
		// WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("shilpaabc");
		driver.findElement(By.name("password")).sendKeys("Sh$ln9606");
		WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));
		loginbutton.click();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		// boolean
		// invisible=wait.until(ExpectedConditions.invisibilityOfElementLocated(driver.findElement(by.xp)))

//		JavascriptExecutor js= (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()",loginbutton);
//		
		System.out.println(driver.getTitle());
	}

}
