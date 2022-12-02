package tests;

import static util.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class WishlistValidationTest extends BaseTest {
	@Test
	public void WishlistValidationtest (Method method) throws InterruptedException {
		
    startTest(method.getName(), "Validate a Wishlist");
		Faker faker = new Faker();// faker is used to name the wishlist randomly 
		String randomwishlistname =faker.lorem().characters(4);
	
	    String emailidinput="test098@yopmail.com";
	  	String password="Testing@123";
	   System.out.println(randomwishlistname);
	   //startTest(method.getName(), "Validate a Wishlist");
	   
	   Thread.sleep(5000);
	    	homePage
	      .openABBemart() // opening of chrome and navigating to application 
	      .loginABBemart();
	     Thread.sleep(4000);
	     loginPage.logintoABBemart(emailidinput, password);// Log in is happening by putting username and password 
	     myaccountPage
	      .NavigationtoMywishlist();// Navigating to my wish list 
	     Thread.sleep(4000);
	     
	     // creating the maximum number of wish list to validate the same 
	     for (int i = 0; i < 4 ; i++) {
	         try { 
	        	 String wishlistname =faker.lorem().characters(4);
	             mywishlistPage.createWishlist(randomwishlistname+wishlistname);
	             System.out.println("All 5 Wishlist are created");
	         } catch (Exception e) {
	             System.out.println(" Not created");
	             
	       System.out.println("(Create new wish list) tab is not visible ");
	}
}
}
}