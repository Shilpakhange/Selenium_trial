package selenium.webdriver.trial;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws IOException {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			 driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			driver.get("https://classic.crmpro.com");

			driver.findElement(By.name("username")).sendKeys("shilpaabc");
			driver.findElement(By.name("password")).sendKeys("Sh$ln9606");
			WebElement loginbutton=driver.findElement(By.xpath("//input[@type='submit']"));

			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",loginbutton);
			driver.switchTo().frame("mainpanel");
			
			//Get all the links and images available on the page:
			List<WebElement>linkslist=driver.findElements(By.tagName("a"));
			System.out.println("Total number of links:"+linkslist.size());
			//Add images to the linkslist:
			linkslist.addAll(driver.findElements(By.tagName("img")));
			System.out.println("Total number of links and imgs :"+linkslist.size());
			
			//Get all the active links:
			ArrayList<WebElement>activelinkslist=new ArrayList();
			for(int i=0;i<linkslist.size();i++)
			{
				if(linkslist.get(i).getAttribute("href")!= null&& !linkslist.get(i).getAttribute("href").contains("javascript"))
				{
					activelinkslist.add(linkslist.get(i));
					System.out.println(linkslist.get(i).getAttribute("href"));
				}
			}
			System.out.println("The total number of active links:"+activelinkslist.size());

			for(int j=0;j<activelinkslist.size();j++)
			{
				HttpURLConnection connectionn=(HttpURLConnection) new URL(activelinkslist.get(j).getAttribute("href")).openConnection();
				connectionn.connect();
				String message=connectionn.getResponseMessage();
				System.out.println(activelinkslist.get(j).getAttribute("href")+" --->"   +message);
				connectionn.disconnect();
			}
				
	}

}
