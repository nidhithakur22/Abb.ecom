package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.Utility.*;

public class DecreaseProductQuantityTest extends BaseTest{

	public int Productquantity;
	
	@Test(dataProvider = "data",dataProviderClass = TestUtil.class)
	  
	  public void DecreaseQuantity(String product, String quantity, String price, String TotalPrice) throws InterruptedException {
	
		//Adding a product from product description page
	        productdescriptionPage.AddProduct(product); 
	        Thread.sleep(6000);
	        System.out.print("cart page\n");
	        Thread.sleep(6000);
	    //getting the product name from the cart page
	       String productname = mycartpage.getProduct(); 
	       System.out.println("In test class Product Name from Application = "+productname);
	       System.out.println("In test class Product Name from Excel   = "+product);
	       Thread.sleep(5000);
	    //decreasing the product quantity with the help of decrement operator (-)
	        Productquantity =  mycartpage.GetQuantity();
	       System.out.println("  Productquantity ="+Productquantity );
	      mycartpage.DecreaseProductQuantity(product);  	  
	  }
	      

	@Test
	public void VerifyQuantity() throws InterruptedException {
	
		int afterDecrease = mycartpage.GetQuantity();
		 //Assert.assertEquals(Expected,Actual)  
	    Assert.assertEquals(afterDecrease,Productquantity-1);
	
	}
}
