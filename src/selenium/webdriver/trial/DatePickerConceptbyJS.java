package selenium.webdriver.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DatePickerConceptbyJS {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("https://spicejet.com");
		WebElement datepicker=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_txt_Fromdate']"));
		
		String date="15-01-2019";
		SelectDateByjs(datepicker,driver,date);
Actions act=new Actions(driver);
act.doubleClick(datepicker).build().perform();
			
		
	}

	
	public static void SelectDateByjs(WebElement element,WebDriver driver,String date)
	{
	JavascriptExecutor js =((JavascriptExecutor) driver);
	js.executeScript("arguments[0].setAttribute('value','"+date+"');",element);
	}
	
}
