package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.opentelemetry.sdk.metrics.data.Data;
import pages.MyCartPage;
import com.test.Utility.*;




public class IncreaseProductQuantityTest extends BaseTest{
	

	@Test(dataProvider = "data",dataProviderClass = TestUtil.class)
	  
	  public void IncreaseQuantity(String product, String quantity, String price, String TotalPrice) throws InterruptedException {
		//Precondition- clear Cart
		// Adding a product using test data
	        productdescriptionPage.AddProduct(product);
	        Thread.sleep(6000);
	        System.out.print("cart page");
	        Thread.sleep(6000);
	   // getting all the product name which is added into the cart page
	        String productname = mycartpage.getProduct();
	       System.out.println("In test class Product name from Application = "+productname);
	       System.out.println("In test class Product name from Excel ="+product);
	    // verifying cart product name with the product name from excel
//	       Assert.assertEquals(productname.replaceAll(",","").trim(),product.replaceAll(",", "").trim());
	       Thread.sleep(5000);
	      
	    // Increasing product quantity by using test data
	      String Productquantity = mycartpage.GetProductQuantity(productname,quantity);
	      
	      System.out.println("In test class product quantity from excel= "+quantity);
	      System.out.println("In test class product Productquantity from Application =  "+Productquantity);
	      
	    // verifying the product quantity after increment
	      Assert.assertEquals(Productquantity.replaceAll(".0", ""), quantity.replaceAll(".0", ""));
	      Thread.sleep(15000);
	     
	       }
	      
	}
	 	    
	

