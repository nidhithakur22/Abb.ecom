package tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.Test;



public class AddToCartProductTest extends BaseTest {
	   @Test(priority = 0, description = "Add a product into the cart")
	    public void AddToCartProduct(Method method) throws InterruptedException {
	        //ExtentReports Description
	     
	    	String productname = "USB Charger, Tvisha - 2A 2Module (Tvisha White)";
	
		       
	   // 	 String emailidinput="test098@yopmail.com";
	//	    	String password="Testing@123";
	//		 homePage
	//	      .openABBemart()
	//	      .loginABBemart();// Navigating to login page 
			 
	    	Thread.sleep(5000);
	//    	loginPage.logintoABBemart(emailidinput, password);
		     productdescriptionPage
	        	.AddProduct(productname);
	        
	 	    }
}
