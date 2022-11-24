package pages;
		
		import java.util.ArrayList;
		
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.TimeoutException;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		
		import util.Log;
		
		public class ProductDescriptionPage extends BasePage{
		
			public ProductDescriptionPage(WebDriver driver) {
				super(driver);
				// TODO Auto-generated constructor stub
			}
		
			/**
			 * Variables
			 */
		
			int waittime=8000;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions a = new Actions(driver);	
			/**
			 * Web Elements
			 */	
			By productSearch			= By.name("q");
			By linkSearch 				= By.xpath("//*[@id='eln-product-products']/div[1]/ol/li/div[3]/div/strong/a/span[2]");											
			By image					= By.xpath("//*[@id=\"magnifier-item-0\"]");
			By qty						= By.xpath("//*[@id='qty']");
			By pincode					= By.xpath("//*[@id=\"product-shipping-postcode\"]");
			By calculateShipping		= By.xpath("//*[@id=\"product-shipping-button\"]");
			By AddToCart				= By.xpath("/html/body/div[6]/main/div/div[2]/div[2]/div[4]/form/div[2]/div/div[2]/button[2]");
			By ShoppingCart				= By.xpath("//*[@id=\"maincontent\"]/div/div[1]/div[2]/div/div/div/a");		
			By HomePage 				= By.xpath("//*[@id=\"html-body\"]/div[5]/header/div[3]/div[2]/a");
			By HomepageShoppingcart		= By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[3]/div[3]/a");
			By ShoppingcartProduct		= By.xpath("//*[@id=\"mini-cart\"]/li/div/div/strong/a");
		
		
			/**
			 * Page Methods
			 * @return 
			 * @throws InterruptedException 
			 */
		
			// Search a product from PDP 
			public ProductDescriptionPage AddProduct(String productname) throws InterruptedException {
				Log.info("product search ");
		
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(productSearch));
				System.out.println("product has located");
				writeText(productSearch, productname);
				
				Thread.sleep(waittime);
				// writeText(productSearch,"CAL19-11B Auxiliary Contact Block");
				a.sendKeys(Keys.ENTER).build().perform();
		
				Thread.sleep(waittime);
				click(linkSearch);
				Thread.sleep(waittime);
			
				System.out.println(driver.getTitle());
				Thread.sleep(waittime);
		
				System.out.println(driver.getCurrentUrl());
		
				Thread.sleep(waittime);
		
				String parent = driver.getWindowHandle();
				System.out.println(parent+ "  "+ driver.getTitle());
				JavascriptExecutor js = (JavascriptExecutor) driver;
				int i =0;
				ArrayList<String> all = new ArrayList<String> (driver.getWindowHandles());
				for(String h : all)
				{
					System.out.println(h+"  "+ driver.getTitle());
					driver.switchTo().window(all.get(i++));
		
				}
		
				js.executeScript("window.scrollBy(0, 1500);");
				clear(qty);
				writeText(qty, "1");
				Thread.sleep(waittime);
				clear(pincode);
				writeText(pincode,"110075");
				Thread.sleep(waittime);
				click(calculateShipping);
				Thread.sleep(waittime);
				click(AddToCart);
				Thread.sleep(waittime);
				click(ShoppingCart);
				Thread.sleep(waittime);
				Log.info("Product has been added into the shopping cart");
				js.executeScript("window.scrollBy(0, 1500);");
				js.executeScript("window.scrollBy(0, -1500);");
	//			Thread.sleep(waittime);
			
				/*	  click(HomePage); Thread.sleep(waittime); click(HomepageShoppingcart);
				 * Thread.sleep(waittime); String pname =
				 * driver.findElement(ShoppingcartProduct).getText();
				 * System.out.println("cart product name ="+pname+
				 * "  searched for:-"+productname );
				 * //System.out.println(pname.compareToIgnoreCase(productname));
				 * click(ShoppingcartProduct);
				 */
		
				return new ProductDescriptionPage(driver);
			}


			
		}
		
		