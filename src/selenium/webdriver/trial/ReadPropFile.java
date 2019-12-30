package selenium.webdriver.trial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile {

	public static void main(String[] args) throws IOException, FileNotFoundException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\Shilpa Khandge\\eclipse-workspace\\selenium_trial\\src\\selenium\\webdriver\\trial\\config.properties");

		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("browser"));

		String bname = prop.getProperty("browser");
		if (bname.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\\\Users\\\\Shilpa Khandge\\\\Downloads\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.findElement(By.xpath(prop.getProperty("fname_xpath"))).sendKeys(prop.getProperty("firstName"));
			driver.findElement(By.xpath(prop.getProperty("lname_xpath"))).sendKeys(prop.getProperty("lastName"));
			driver.findElement(By.xpath(prop.getProperty("Email_xpath"))).sendKeys(prop.getProperty("Email"));

		} else if (bname.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Shilpa Khandge\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}
		
		
	}
	
	

}
