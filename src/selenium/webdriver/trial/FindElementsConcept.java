package selenium.webdriver.trial;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		
		driver.get("https://www.facebook.com/");
		
		//USe following method to get total no. of links or buttons or input fields on the webpage
		List <WebElement> listobject=driver.findElements(By.tagName("a"));
		
		System.out.println(listobject.size());
		
		for(int i=0;i<listobject.size();i++)
		{
			System.out.println(listobject.get(i).getText());
		}
		
	}

}
