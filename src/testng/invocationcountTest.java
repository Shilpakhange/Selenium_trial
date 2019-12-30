package testng;

import org.testng.annotations.Test;

public class invocationcountTest {

	//Script will be executed 10 times
	@Test(invocationCount=10)
	public void invocTest()
	{
		System.out.println("In the invoc test");
	}
	
}
