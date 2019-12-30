package selenium.webdriver.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightclickConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Shilpa Khandge\\\\Downloads\\\\chromedriver_win32 (1)\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightclickbtn=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		Actions act=new Actions(driver);
		act.contextClick(rightclickbtn).build().perform();
		
		WebElement copy=driver.findElement(By.cssSelector(".context-menu-icon-copy"));
		copy.click();
	}
	

}
