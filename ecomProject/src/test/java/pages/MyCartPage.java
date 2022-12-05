
package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import util.Log;

public class MyCartPage extends BasePage{

	 /**
     * Constructor
     */
	public MyCartPage(WebDriver driver) {
		super(driver);
	}


    /**
     * Variables
     */
	int waittime=8000;
	public String productname1;
	public String ProductquantityfromApp;
	public String xpart1,xpart2,xpart3;
	public int qnty;
	int qntty=0;
	public WebElement lsElement;
	String filepath = "C:\\Users\\Asus\\Desktop\\ProductItem.xlsx";
	SoftAssert softassert;	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions a = new Actions(driver);	
	
	/**
	 * Web Elements
	 */	

	By HomePage 				= By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[3]/div[2]/a");

	By HomepageShoppingcart		= By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[3]/div[3]/a");

	By ShoppingcartProduct		= By.xpath("/html/body/div[4]/header/div[3]/div[3]/div/div/div/div[2]/div[5]/div/a");

	By quantityincart		 	= By.xpath("//input[contains (@id,'cart-item')]");

	By minusQuantity			= By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[2]/tr/td[3]/div/div/span[1]");

	
	//getProduct method is fetching product name from Application
	
	public String getProduct() throws InterruptedException { 
		System.out.println("\n GetProduct from Application \n");

		click(HomePage); // click to the home page
		click(HomepageShoppingcart);  // click to the shopping cart
		Thread.sleep(waittime);
	
		//store all the product names into list variable
		List <WebElement> list = driver.findElements(By.xpath("//*[@class='prod_name']"));
		
		// iterate list elements 
		for(WebElement lsElement : list)

		{
			productname1 = lsElement.getText();
			System.out.println(lsElement.getText()+"       ");
			System.out.println("\n product Name from Application= "+ productname1);
			
		}
	return productname1;
	}

	/**
	 * @param Productname
	 * @param quantity
	 * @return
	 * @throws InterruptedException
	 */
	/* GetProductQuantity method is fetching the quantity from excel and increasing product quantity in application accordingly */
	public int GetQuantity() throws InterruptedException {

		ArrayList <WebElement> list1 = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[contains (@id,'cart-item') ]"));
			System.out.println(list1.size());
		for(WebElement lsElement1 : list1)  	
		{   
					ProductquantityfromApp =lsElement1.getAttribute("value");
				  System.out.println(" product quantity from Application = "+ProductquantityfromApp );
				  qntty = Integer.parseInt(ProductquantityfromApp);
				  Thread.sleep(7000);	  	  	
		}
		return qntty;
			 
	}
	
	
	/* GetProductQuantity method is fetching the quantity from excel and increasing product quantity in application accordingly */
	public String GetProductQuantity(String Productname1, String quantity) throws InterruptedException {

		js.executeScript("window.scrollBy(0, 275);");
		ArrayList <WebElement> list1 = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[contains (@id,'cart-item') ]"));
		
		for(WebElement lsElement1 : list1)  	
		{  
		//	if(Productname1.equalsIgnoreCase(productname1)) {
			 for(int i =0; i<=list1.size();i++) {			  
				  lsElement1.click(); 
				  lsElement1.clear();
				  lsElement1.sendKeys(quantity.replaceAll(".0", ""));
				  Thread.sleep(7000);	  
			  	}	
		}
		a.sendKeys(Keys.ENTER).build().perform();
		js.executeScript("window.scrollBy(0, 275);");
		Thread.sleep(waittime);
				 
//	}
		return quantity;
	}
	//DecreaseProductQuantity method is decreasing the product quantity by using decrement operator (-)
	public String DecreaseProductQuantity(String Productname) throws InterruptedException {
		
		System.out.println("\n Decrease Quantity on Products by 1");
			
		List<WebElement> minusOperator = (List<WebElement>)  driver.findElements(By.className("minus"));
		int size=minusOperator.size();
		 int i=2;
		size=size*2;
		for(;i<=size;i=i+2)
		{
		
			js.executeScript("window.scrollBy(0, 230)");
			String s1= "//*[@id='shopping-cart-table']/";
			String s2 = "tbody["+i;
			String s3= "]/tr/td[3]/div/div/span[1]";
			String makexpath  =s1+s2+s3;
			Thread.sleep(10000);
			Thread.sleep(waittime);
			driver.findElement(By.xpath(makexpath)).click();
			js.executeScript("window.scrollBy(0, 230)");
			System.out.println("Decreased quantity");
			Thread.sleep(waittime);
			Thread.sleep(10000);
			}
	 		
		return Productname;

	}
	
	//Place	an order method

	By productSearch			= By.xpath("//input[contains (@id,'search_')]");
	By linkSearch 				= By.xpath("//*[@id=\"eln-product-products\"]/div[1]/ol/li/div[3]/div/strong/a/span[2]");
	By image					= By.xpath("//*[@id=\"magnifier-item-0\"]");
	By qty						= By.xpath("//*[@id=\"qty\"]");
	By pincode					= By.xpath("//*[@id=\"product-shipping-postcode\"]");
	By calculateShipping		= By.xpath("//*[@id=\"product-shipping-button\"]");
	By AddToCart				= By.xpath("/html/body/div[6]/main/div/div[2]/div[2]/div[4]/form/div[2]/div/div[2]/button[2]");
	By BuyNow					= By.xpath("//*[@id=\"buy-now\"]");
	By ShoppingCart				= By.xpath("//*[@id=\"maincontent\"]/div/div[1]/div[2]/div/div/div/a");		
	By PlaceOrder				= By.xpath("//*[@id=\"cart-totals\"]/button/a");
	By FreeShipping				= By.xpath("//*[@id=\"s_method_marketplace_221400_free_shipping\"]");
	By NextToPayment			= By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
	By TermCondition			= By.xpath("//*[@id=\"customTCcheckbox\"]");
	By PaywithRazorpay			= By.xpath("//*[@id=\"abb-pay-with-razorpay\"]");
	By PayLater					= By.xpath("//*[@id=\"form-common\"]/div[1]/div/div/div[2]/div[2]/div/button[6]");
	By street					= By.xpath("//input[contains (@name,'street')]");
	By city						= By.xpath("//input[contains (@name,'city')]");
	By email					= By.xpath("//*[@id=\"customer-email\"]");
	
	By firstname 				= By.xpath("//*[@id=\"GY0TQD6\"]");
	By lastName 				= By.xpath("//*[@id=\"A6307PL\"]");
	By phonenumber				= By.xpath("//input[contains (@name,'telephone')]");
	
	By Next 					= By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
	
	By searchbar				= By.xpath("/html/body/div[4]/header/div[3]/div[4]/div[2]/form/div[1]/div/input");

	// Search a product from PDP 
	public MyCartPage PlaceAProduct(String productname) throws InterruptedException {
		Log.info("product search ");

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(productSearch));
			System.out.println("product has located");
			writeText(productSearch,productname);
		}
		catch(TimeoutException e) {
			System.out.println("product search isn't searchable");
		}
		Thread.sleep(waittime);
		// writeText(productSearch,"CAL19-11B Auxiliary Contact Block");
		a.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(waittime);
		click(linkSearch);
		Thread.sleep(waittime);
		Thread.sleep(30000);
		System.out.println(driver.getTitle());
		Thread.sleep(waittime);

		System.out.println(driver.getCurrentUrl());

		Thread.sleep(waittime);

		String parent = driver.getWindowHandle();
		System.out.println(parent+ "  "+ driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor) driver;

		ArrayList<String> all = new ArrayList<String> (driver.getWindowHandles());
		for(String h : all)
		{
			System.out.println(h+"  "+ driver.getTitle());
			driver.switchTo().window(all.get(1));

		}

		js.executeScript("window.scrollBy(0, 1500);");
		clear(qty);
		writeText(qty, "1");
		Thread.sleep(waittime);
		clear(pincode);
		writeText(pincode,"110086");
		Thread.sleep(waittime);
		click(calculateShipping);
		Thread.sleep(waittime);
		click(BuyNow);
		Thread.sleep(waittime);
//		click(ShoppingCart);
//		Thread.sleep(waittime);
//		click(PlaceOrder);
//		Thread.sleep(waittime);
//		Thread.sleep(waittime);
//		click(FreeShipping);
//		Thread.sleep(waittime);
//		click(NextToPayment);
//		Thread.sleep(waittime);
//		click(TermCondition);
//		Thread.sleep(waittime);
//		click(PaywithRazorpay);
//		Thread.sleep(waittime);
//		ArrayList<String> paymentWindow = new ArrayList<String> (driver.getWindowHandles());
//		for(String Paywindow : paymentWindow ) {
//			System.out.println(Paywindow);
//			driver.switchTo().window(paymentWindow.get(1));
//		}
//		Thread.sleep(waittime);
//		click(PayLater);
//		Thread.sleep(waittime);
//		Thread.sleep(waittime);
//		writeText(email,"smith.test1@yopmail.com");
//		Thread.sleep(waittime);
//		writeText(firstname,"Nidhi");
//		Thread.sleep(waittime);
//		writeText(lastName,"Thakur");
//		Thread.sleep(waittime);
		writeText(street,"Karol bagh Delhi");
		Thread.sleep(waittime);
		writeText(city,"Delhi");
		Thread.sleep(waittime);
		writeText(phonenumber,"7838772822"	);
		Thread.sleep(waittime);
		click(NextToPayment);
		Thread.sleep(waittime);
		click(TermCondition);
		Thread.sleep(waittime);
		click(PaywithRazorpay);
		
		
		
		return new MyCartPage(driver);
	}

	public void product(String product) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread.sleep(3000);
		writeText(searchbar,product);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(waittime);

	}

}

