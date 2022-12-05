package tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class AddNewShippingAddressTest  extends BaseTest {
	
	@Test
	
	public void validLoginTest(Method method) throws InterruptedException {

		 myaccountPage
	      .NavigatingtoAddressBook(); 
	   Thread.sleep(4000);
	   addressbookPage
	   .newShippingaddress();
		
		
		
}
}