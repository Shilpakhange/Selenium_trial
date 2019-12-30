package selenium.webdriver.trial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Yahoosearchtest {

	public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Shilpa Khandge\\\\Downloads\\\\chromedriver_win32 (1)\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();

      driver.get("https://in.yahoo.com");
      System.out.println(driver.getCurrentUrl());
      
      String title=driver.getTitle();
      System.out.println(title);
      
      if (title.equals("Yahoo India"))
      {
    	  System.out.println("Correct title");
    	  
      }
      else
      {
    	  System.out.println("Incorrect title");
      }
      driver.quit();

	}

}
