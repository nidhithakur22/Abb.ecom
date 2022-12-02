package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class MyWishlistPage extends BasePage{

	public MyWishlistPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 /**
     * Web Elements
     */
	
	By createList = By.xpath("//*[@id=\"wishlist-create-button\"]");
	By newlist      = By.xpath("//*[@id=\"wishlist-new-wishlist-lightbox\"]/div/div[2]/form/input");
	By createButton = By.xpath("//*[@id=\"add-to-wishlist\"]");
	
	
	 public MyWishlistPage createWishlist(String randomwishlistname) throws InterruptedException {
		
		
			
		 click(createList);
		 Thread.sleep(4000);
		 writeText(newlist,randomwishlistname);
		 Thread.sleep(5000);
		 click(createButton);
		 
		 Thread.sleep(8000);
		 
		 return this;
		
		 
		
	}
}
