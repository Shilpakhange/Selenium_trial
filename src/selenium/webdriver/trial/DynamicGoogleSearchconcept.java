package selenium.webdriver.trial;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearchconcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("testing");
		List <WebElement>ll=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		System.out.println(ll.size());
		
		for(int i=0;i<ll.size();i++)
		{
			// str=ll.get(i).getText();
			//System.out.println(str);
			if(ll.get(i).getText().contains("testing types")) {
				ll.get(i).click();
				break;
			}
		}
		
	}

}
