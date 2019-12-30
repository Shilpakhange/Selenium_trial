package testng;

import org.testng.annotations.Test;

public class ExceptionTimeouttest {

//	@Test(invocationTimeOut = 2)
//	public void infiniteLoop() {
//		int i = 1;
//		while (i == 1) {
//			System.out.println(i);
//		}
//	}
	@Test(expectedExceptions=NumberFormatException.class)
	public void test()
	{
		String aa="100z";
		Integer.parseInt(aa );
	}
}
