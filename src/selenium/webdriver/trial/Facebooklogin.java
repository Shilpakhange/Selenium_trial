package selenium.webdriver.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebooklogin {
	
  

	public static void main(String[] args) {

		
		//WebDriver driver;

		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shilpa Khandge\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.MICROSECONDS);

			
			driver.get("https://www.facebook.com");
			//WebDriverWait wait =new WebDriverWait(driver,10);
			//WebElement Firstname=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("firstname"))));
			WebElement Firstname=driver.findElement(By.name("firstname"));
			Firstname.sendKeys("Shilpa");
			WebElement Surname=driver.findElement(By.name("lastname"));
			Surname.sendKeys("Khandge");
			
			WebElement Telephone=driver.findElement(By.id("u_0_q"));
			Telephone.sendKeys("9960982045");
			
			WebElement rbutton=driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
			rbutton.click();
			
			//To select values from drop-down list use select method as beleow-> 
			
			WebElement day=driver.findElement(By.id("day"));
			WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
			WebElement year=driver.findElement(By.cssSelector("#year"));
			
			
			selectDropdownvalue(day,"15");
			selectDropdownvalue(month, "Mar");
			selectDropdownvalue(driver.findElement(By.cssSelector("#year")), "1987");
			
//			Select cellDay = new Select(driver.findElement(By.id("day")));
//			cellDay.selectByIndex(2);
//			
//			Select CellMonth=new Select(driver.findElement(By.xpath("//select[@id='month']")));
//			CellMonth.selectByVisibleText("Mar");
//			
//			Select CellYear=new Select(driver.findElement(By.cssSelector("#year")));
//			CellYear.selectByValue("1987");
//			
//			driver.findElement(By.id("u_0_11")).click();
//			
//			driver.findElement(By.xpath("//a[contains(text(),'Create a Page')]")).click();
//			driver.navigate().back();
//			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void selectDropdownvalue(WebElement element,String value) {
		
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
}
