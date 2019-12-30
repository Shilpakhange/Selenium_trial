package com.Datadriventest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebtableHandle {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shilpa Khandge\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

	String beforeXpath_company="//*[@id=\"customers\"]/tbody/tr[";
	String afterXpath_company="]/td[1]";
	
	String beforeXpath_contact="//*[@id=\"customers\"]/tbody/tr[";
	String afterXpath_contact="]/td[2]";
	
	String beforeXpath_country="//*[@id=\"customers\"]/tbody/tr[";
	String afterxpath_country="]/td[3]";
	
	int rowcount=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
	System.out.println(rowcount);
	
	
	//Writing webtable to the excelsheet---
	Xls_Reader reader=new Xls_Reader("C:\\Users\\Shilpa Khandge\\eclipse-workspace\\selenium_trial\\testData\\ebaytest.xlsx");
	if(!reader.isSheetExist("Testdata"))
	{
		reader.addSheet("Testdata");
		reader.addColumn("Testdata", "Company");
		reader.addColumn("Testdata", "Contact");
		reader.addColumn("Testdata", "Country");
		
	}
	
	for(int i=2;i<=rowcount;i++)
	{
	
		String actualXpath_company=beforeXpath_company+i+afterXpath_company;
		String companyName=driver.findElement(By.xpath(actualXpath_company)).getText();
		System.out.println(companyName);
		reader.setCellData("Testdata", "Company", i, companyName);
		
		String actualXpath_contact=beforeXpath_contact+i+afterXpath_contact;
		String contactName=driver.findElement(By.xpath(actualXpath_contact)).getText();
		System.out.println(contactName);
		reader.setCellData("Testdata", "Contact", i, contactName);
		
		String actualXpath_country=beforeXpath_country+i+afterxpath_country;
		String countryName=driver.findElement(By.xpath(actualXpath_country)).getText();
		System.out.println(countryName);
		reader.setCellData("Testdata", "Country", i, countryName);
		
		
	}
	

//		
//		String beforeXpath_company = "//*[@id=\"customers\"]/tbody/tr[";
//		String afterXpath_company1 = "]/td[";
//		String afterXpath_company2 = "]";
//		
////		//rowwise value printing---
//		// for(int j=2;j<=7;j++)
////	{
////			for(int i=1;i<=3;i++)
////			{
////				String actualXpath=beforeXpath_company+j+afterXpath_company1+i+afterXpath_company2;
////				String datavalue=driver.findElement(By.xpath(actualXpath)).getText();
////				System.out.println(datavalue);
////			}
////			System.out.println("-------------------------------");
////		}
////		
//
//		// columnwise value printing--
//		
//		for (int i = 1; i <= 3; i++) {
//			for (int j = 2; j <= 7; j++) {
//				String actualXpath = beforeXpath_company + j + afterXpath_company1 + i + afterXpath_company2;
//				String datavalue = driver.findElement(By.xpath(actualXpath)).getText();
//				System.out.println(datavalue);
//			}
//			System.out.println("-------------------------------");
//
//		}
//
	}

}
