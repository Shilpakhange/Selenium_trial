package selenium.webdriver.trial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthconcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Shilpa Khandge\\\\Downloads\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		//Handle authentication pop-up using below code
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		//String message=driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
		//or
		String message=driver.findElement(By.cssSelector("p")).getText();
		System.out.println(message);
	}

}
