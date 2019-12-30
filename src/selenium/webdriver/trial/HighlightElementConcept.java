package selenium.webdriver.trial;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightElementConcept {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com");

		driver.findElement(By.name("username")).sendKeys("shilpaabc");
		driver.findElement(By.name("password")).sendKeys("Sh$ln9606");

		WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));

		// flash(loginbutton,driver);//To highlight the particular element.
		drawborder(loginbutton, driver);// To draw border for particular element.
		generatealert(driver, "The login button has an issue");// To generate runtime alert
		driver.switchTo().alert().accept();
		refreshBrowser(driver);// To refresh the browser
		System.out.println(getTitleByJS(driver));// To get the title of the current page
		System.out.println(getPageInnerText(driver));
		//scrollPageDown(driver);
		WebElement forgotlink=driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
		
		scrollIntoView(driver,forgotlink);

//		Taking screenshot using below method
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src,
//				new File("C:\\\\Users\\\\Shilpa Khandge\\\\eclipse-workspace\\\\selenium_trial\\\\src\\\\error.png"));
	}

	public static void flash(WebElement element, WebDriver driver) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changecolor("rgb(0,200,0)", element, driver);
			changecolor(bgcolor, element, driver);

		}
	}

	public static void changecolor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor= '" + color + "'", element);
	}

	public static void drawborder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		// js.executeScript("arguments[0].style.border='3px solid green'",
		// element);//will make border with green color

	}

	public static void generatealert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");

	}

	public static void refreshBrowser(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageText = (String) js.executeScript("return document.documentElement.innerText");
		return pageText;
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
