package selenium.webdriver.trial;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("window-size=1400,800");
		option.addArguments("headless");
		

		WebDriver driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			driver.get("https://classic.crmpro.com");
			System.out.println(driver.getTitle());
			driver.findElement(By.name("username")).sendKeys("shilpaabc");
			driver.findElement(By.name("password")).sendKeys("Sh$ln9606");
			WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));
			//loginbutton.click();
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()",loginbutton );
            
            System.out.println(driver.getTitle());
	}

}
