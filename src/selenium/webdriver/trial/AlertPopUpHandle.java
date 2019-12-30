package selenium.webdriver.trial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(2000);
		
		String str=driver.switchTo().alert().getText();
		
		System.out.println(str);
		if(str.equals("Please enter a valid user name"))
		{
			System.out.println("Correct text");
		}
				
		else
		{
			System.out.println("Wrong text");
		}
		
		driver.switchTo().alert().accept();//---To click on ok button on pop up window.
		//driver.switchTo().alert().dismiss();//---To click on cancel button on popup window
		
		
		
	}

}
