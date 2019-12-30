package com.Datadriventest;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterisedTest {

	public static void main(String[] args) throws IOException {

		
		//Launch the browser->
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://register.rediff.com/commonreg/index.php");


		
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Shilpa Khandge\\eclipse-workspace\\selenium_trial\\testData\\ebaytest.xlsx");

		int rowcount=reader.getRowCount("RegTestData");
		boolean b=reader.addColumn("RegTestData", "Status");//--To add new column to the excel sheet

		int colcount=reader.getColumnCount("RegTestData");
//		System.out.println(colcount);
		System.out.println(rowcount);
		for(int i=2;i<=rowcount;i++)
			try {
				{
				
					//Fetch data for each row->
					System.out.println("-----------------------");
					String fname=reader.getCellData("RegTestData", "businessname", i);
					System.out.println(fname);
					
					String email=reader.getCellData("RegTestData", "email", i);
					System.out.println(email);
					
					String password=reader.getCellData("RegTestData", "password", i);
					System.out.println(password);
					
				
					//enter data from excel to the webpage->
					driver.findElement(By.name("fullname")).clear();;
					driver.findElement(By.name("fullname")).sendKeys(fname);

					driver.findElement(By.name("emailid")).clear();;
					driver.findElement(By.name("emailid")).sendKeys(email);
					
					driver.findElement(By.name("pass")).clear();;
					driver.findElement(By.name("pass")).sendKeys(password);

					driver.findElement(By.name("repass")).clear();;
				driver.findElement(By.name("repass")).sendKeys(password);
					
					reader.setCellData("RegTestData", "Status", i, "Pass");


				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}
}