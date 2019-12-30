package selenium.webdriver.trial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class ExtraSpecialLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.facebook.com");
		//driver.findElement(new ByAll(By.id("u_0_l"),By.name("firstname"),By.xpath("//input[@id='u_0_l']"))).sendKeys("shilpa");
		//driver.findElement(new ByIdOrName("u_0_l")).sendKeys("shilpa");
		driver.findElement(new ByChained(By.xpath("//div[@class='mbm _1iy_ _a4y _3-90 lfloat _ohe']"),
				By.id("u_0_k"),
				By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']"),
				By.name("firstname"))).sendKeys("shilpa");
	}

}
