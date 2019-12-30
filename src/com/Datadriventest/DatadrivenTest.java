package com.Datadriventest;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

public class DatadrivenTest {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Shilpa Khandge\\eclipse-workspace\\selenium_trial\\testData\\ebaytest.xlsx");

		// String firstname=reader.getCellData("RegTestData", 1, 2);
		String fullname = reader.getCellData("RegTestData", "businessname", 2);
		String email = reader.getCellData("RegTestData", "email", 2);
		String password = reader.getCellData("RegTestData", "password", 2);
		String phone = reader.getCellData("RegTestData", "phoneno", 2);

//		String birthdate = reader.getCellData("RegTestData", "birthdate", 2);
//		String birthday[] = birthdate.split(",");
//		String month = birthday[0];
//		String day = birthday[1];
//		String year = birthday[2];

		System.out.println(fullname);
		System.out.println(email);
		System.out.println(password);
		//System.out.println(phone);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://register.rediff.com/commonreg/index.php");

		driver.findElement(By.name("fullname")).sendKeys(fullname);


		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("pass")).sendKeys(password);

		driver.findElement(By.name("repass")).sendKeys(password);

	}

}
