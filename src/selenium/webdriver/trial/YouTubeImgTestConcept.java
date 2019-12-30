package selenium.webdriver.trial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class YouTubeImgTestConcept {

	public static void main(String[] args) throws InterruptedException, FindFailed {

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("https://www.youtube.com/watch?v=0iNORdS0hBQ&list=PLs1BK_1gOjLD_5T8SxzIwiTgKUsCoPd2G");
		
		//Sikuli script to automate the flash object
		Screen s=new Screen();
		Pattern pauseimg=new Pattern("pausebtn.png");
		
		s.wait(pauseimg,2000);
		s.click();
		
				
		
		
	}

}
