package selenium.webdriver.trial;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BootStrapdropboxHandle {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Shilpa Khandge\\\\Downloads\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://accounts.google.com");
		WebElement dropBox=driver.findElement(By.xpath("//div[@class='ry3kXd Ulgu9']"));
		dropBox.click();
		
//		driver.findElement(By.xpath("//div[@class='MocG8c B9IrJb LMgvRb KKjvXb']")).click();
//		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='OA0qNb ncFHed']/div"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			String str=list.get(i).getAttribute("data-value");
			System.out.println(str);
			if (str.equals("ne"))
			{
				list.get(i).click();
				break;
			}
			
		}
		
	}

}
