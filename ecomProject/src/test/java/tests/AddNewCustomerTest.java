package tests;

import java.lang.reflect.Method;
import static util.ExtentTestManager.startTest;
import org.testng.annotations.Test;

public class AddNewCustomerTest extends BaseTest {
	 @Test
	public void AddingCustomer (Method method) throws InterruptedException {
	
	
	     homePage
	      .openABBemart()
	      .loginABBemart();
	   Thread.sleep(4000);
	     loginPage
	      .newcustomer();
	   Thread.sleep(8000);
	     addnewAccountPage
	      .addnewcustomer();
}
}
