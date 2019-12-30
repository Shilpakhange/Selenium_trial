package selenium.webdriver.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		
		driver.get("https://www.ebay.com/");
		
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("java");
		//driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("java");
		
		driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("java");
		
		//in case of dynamic ids need to use following functions:
		//Use starts-with function for following ids
		//if id=gh-ac-123
		//id =gh-ac-456
		
		//driver.findElement(By.xpath("//input[starts-with(@id,'gh-ac-')]")).sendKeys("java");
		
		//USe ends-with function for following type of ids:
		//234-test-gh-ac
		//895-t-gh-ac
		
		//driver.findElement(By.xpath("//input[ends-with(@id,'-gh-ac')]")).sendKeys("java");
		
		//Use contains functions for all types of links as follows:
		
		driver.findElement(By.xpath("//a[contains(text(),'Advanced')]")).click();
				
		
		

	}

}
