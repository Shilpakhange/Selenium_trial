package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngbasic {

	
	
	@BeforeSuite
	public void setUp() {
		System.out.println("Setting up environment");
	}
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("launching browser");
	}
	
	@BeforeMethod
	public void enterUrl()
	{
		System.out.println("Entering url");
	}

	@BeforeTest
	public void login()
	{
		System.out.println("logging into the app");
	}
	
	@Test
	public void googletitleTest()
	{
		System.out.println("google title test");
	}
	
	@AfterSuite
	public void generateReport()
	{
		System.out.println("generating report");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("close browser");
	}
	@AfterMethod
	public void logout()
	{
		System.out.println("log out");
	}
	@AfterTest
	public void deleteallCookies()
	{
		System.out.println("delete all cookies");
	}
}

