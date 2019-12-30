package selenium.webdriver.trial;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HandleFileUpload {

	public static void main(String[] args) {

		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\\\Users\\\\Shilpa Khandge\\\\Downloads\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			driver.get("https://mail.google.com/mail/");

//		driver.get("https://accounts.google.com/signin");
//		
			driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("hajareshilpa@gmail.com");
			driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();

			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sh$ln9606");
		
			//driver.findElement(By.id("passwordNext")).click();//--Gets exception as ElementClickInterceptedException: element click intercepted:

			//Below code will handle the above exception
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.id("passwordNext"))).click().perform();
			 driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
			 driver.switchTo().window(driver.getWindowHandle());
			 
			//File upload using robot class as follows---:This method is used when Html tag is other than 'input'
			
			 driver.findElement(By.xpath("//div[starts-with(@id,':s') and @class='a1 aaA aMZ']")).click();
			 Thread.sleep(2000);
			 Robot robo=new Robot();
			 
			 //To copy filepath to the systemclipboard--
			 StringSelection str=new StringSelection("C:\\Users\\Shilpa Khandge\\Documents\\SHILPA\\shilpa_practice_book");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			
			//To paste the filepath in address bar
			
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			
			//To release the ctrl+v keys--
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_V);
			
			//Press enter key--
			robo.keyPress(KeyEvent.VK_ENTER);
			//Release enter key--
			robo.keyRelease(KeyEvent.VK_ENTER);
			
			//sendkeys won't work for file upload in this case as the html tag is not 'input'
			// driver.findElement(By.xpath("//div[starts-with(@id,':s') and @class='a1 aaA aMZ']")).sendKeys("C:\\Users\\Shilpa Khandge\\Documents\\doc.doc");

			 
						
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
