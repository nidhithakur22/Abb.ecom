package tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.Test;



public class AddToCartProductTest extends BaseTest {
	   @Test(priority = 0, description = "Add a product into the cart")
	    public void AddToCartProduct(Method method) throws InterruptedException {
	        //ExtentReports Description
	       // startTest(method.getName(), "Valid Login Test");
	    	String emailidinput="smith.test1@yopmail.com";
	    	String password="smith@123";
	    	String productname = "CAL19-11B Auxiliary Contact Block";
	    	homePage
	    		.openABBemart()
	    		.loginABBemart();
	        loginPage
	        	.logintoABBemart(emailidinput, password);
	        Thread.sleep(5000);
	        productdescriptionPage
	        	.AddProduct(productname);
	        
	 	    }
}
