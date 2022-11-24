package tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;



public class PlaceOrderTest extends BaseTest {

	  @Test(priority = 0, description = "Add a product into the cart")
	    public void PlaceOrder(Method method) throws InterruptedException {
	        //ExtentReports Description
	       // startTest(method.getName(), "Valid Login Test");
	    	String emailidinput="smith.test1@yopmail.com";
	    	String password="smith@123"
	    			;
	    	String productname = "WIRE HARNESS KIT / ACSX80 R7 400/500V";
	    	homePage
	    		.openABBemart()
	    		.loginABBemart();
	        loginPage
	        	.logintoABBemart(emailidinput, password);
	        Thread.sleep(5000);
	        mycartpage.
	       			PlaceAProduct(productname);
	     
}
}