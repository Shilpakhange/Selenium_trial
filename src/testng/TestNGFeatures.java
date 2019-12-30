package testng;
import org.testng.annotations.Test;

public class TestNGFeatures {

	@Test
	public void loginPage()
	{
		System.out.println("login test");
		//int i=9/0;
	}
	@Test(dependsOnMethods="loginPage")
	public void searchPage()
	{
		System.out.println("Searchpage test");
	}
	@Test(dependsOnMethods="loginPage")
	public void homePage()
	{
		System.out.println("Homepage test");
	}
	@Test(dependsOnMethods="loginPage")
	public void regPage()
	{
		System.out.println("Reg test");
	}
}

