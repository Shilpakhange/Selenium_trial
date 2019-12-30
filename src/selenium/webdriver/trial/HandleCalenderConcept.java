package selenium.webdriver.trial;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleCalenderConcept {

	public static <integer> void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com");

		driver.findElement(By.name("username")).sendKeys("shilpaabc");
		driver.findElement(By.name("password")).sendKeys("Sh$ln9606");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));

		js.executeScript("arguments[0].click()", loginbutton);

		driver.switchTo().frame("mainpanel");

		String date = "31-September-2017";
		String dateval[] = date.split("-");
		String day = dateval[0];
		String month = dateval[1];
		String year = dateval[2];

		Select sel1 = new Select(driver.findElement(By.name("slctMonth")));
		sel1.selectByVisibleText(month);

		Select sel2 = new Select(driver.findElement(By.name("slctYear")));
		sel2.selectByVisibleText(year);

		// daycell xpath:-
		// div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		// div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]

		String beforexpath = "//div[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterxpath = "]/td[";

		boolean flag = false;
		String dayval=null;
		for (int i = 2; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {

				try {
					 dayval = driver.findElement(By.xpath(beforexpath + i + afterxpath + j + "]")).getText();
				} catch (Exception e) {
					System.out.println("Please enter valid day");
					flag=false;
					break;

				}
				System.out.println(dayval);
				if (dayval.equals(day)) {

					driver.findElement(By.xpath(beforexpath + i + afterxpath + j + "]")).click();
					flag = true;
					break;
				}

			}

			if (flag) {
				break;
			}

		}

	}

}
