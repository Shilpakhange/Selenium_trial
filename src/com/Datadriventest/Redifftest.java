package com.Datadriventest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.Testutil;

public class Redifftest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		
		driver.get("https://register.rediff.com/commonreg/index.php");

	}
	
	@DataProvider
	public Iterator<Object[]> gettestData()
	{
		ArrayList<Object[]>mydata=Testutil.getDatafromExcel();
		Iterator<Object[]>it=mydata.iterator();
		return it;
	}
	
	@Test(dataProvider="gettestData")
	public void redifTest(String fname,String email,String password)
	{
		driver.findElement(By.name("fullname")).clear();;
		driver.findElement(By.name("fullname")).sendKeys(fname);

		driver.findElement(By.name("emailid")).clear();;
		driver.findElement(By.name("emailid")).sendKeys(email);
		
		driver.findElement(By.name("pass")).clear();;
		driver.findElement(By.name("pass")).sendKeys(password);

		driver.findElement(By.name("repass")).clear();;
		driver.findElement(By.name("repass")).sendKeys(password);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
