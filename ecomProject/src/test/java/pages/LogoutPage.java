package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Log;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By myaccount 		= By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[3]/div[1]/div/a");
	By logout			= By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[8]/a");
	
	
	 public LogoutPage Logout() throws InterruptedException {
	        Log.info("Logout from ABBEmart Application .");
	        Thread.sleep(8000);
	        click(myaccount);
	        Thread.sleep(8000);
	        click(logout);
	        return this;
	    }
}
