package tests;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.MyorderPage;
import com.test.Utility.TestUtil;

public class MyordersVerifyTest extends BaseTest{
	

	 @Test(priority=0, dataProvider = "Exceldata",dataProviderClass = TestUtil.class)// Getting data from excel through data provider 

		public void VerifyingOrders (String Order, String OrderTotal ) throws Exception {
		 String emailidinput="test098@yopmail.com";
	    	String password="Testing@123";
		 homePage
	      .openABBemart()
	      .loginABBemart();// Navigating to login page 
		 
	     Thread.sleep(5000);
	     loginPage.logintoABBemart(emailidinput, password); // Log in is happening by putting username and password 
	     myaccountPage
	      .NavigatingtoMyorders();// Now navigating to my orders page 
	     Thread.sleep(5000);
	     myorderPage 
	      .MyordersVerify();    // Getting data from application to verify the same 
	     Thread.sleep(9000);
	     Assert.assertEquals(myorderPage.OrderId // comparing the data from excel and application
		        , Order);
	 }
}


