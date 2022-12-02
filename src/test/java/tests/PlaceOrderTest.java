package tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;



public class PlaceOrderTest extends BaseTest {

	  @Test(priority = 0, description = "Add a product into the cart")
	    public void PlaceOrder(Method method) throws InterruptedException {
	        //ExtentReports Description
	       // startTest(method.getName(), "Valid Login Test");
	    
	    			
	    	String productname = "KLF-S T6 KEY LOCK EQ.20007 F/ROT.HAND";
	    
	        Thread.sleep(5000);
	        mycartpage.
	       			PlaceAProduct(productname);
	     
}
}