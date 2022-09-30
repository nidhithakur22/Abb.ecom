package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Log;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	 /**
     * Web Elements
     */
    
    By username          = By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[3]/div[1]/div/a/span");
   
    
  
    
    /**
     * Variables
     */
    String baseURL = "https://stage.shop.in.abb.com/";
    
    
    /**
     * Page Methods
     * @throws InterruptedException 
     */
    
    public String verifyMyAccountUserName() throws InterruptedException {
        Log.info("Verifying the login email id");
        //String emailID = readText(emailid);
        Thread.sleep(5000);
      System.out.println(readText(username));
               
        return readText(username);
    }
	
}
