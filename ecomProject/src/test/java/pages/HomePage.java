package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Log;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
     * Web Elements
     */
    By loginregister             = By.xpath("//*[@id=\"html-body\"]/div[4]/header/div[3]/div[1]/div/a");
    
    /**
     * Variables
     */
    String baseURL = "https://stage.shop.in.abb.com/";
    
    
    /**
     * Page Methods
     * @throws InterruptedException 
     */
    
    //Go to Login Page
    public HomePage openABBemart() throws InterruptedException {
        Log.info("Opening ABB emart.");
        driver.get(baseURL);
        Thread.sleep(5000);
        return this;
    }
    
    public LoginPage loginABBemart() throws InterruptedException {
        Log.info("Click on login ABB emart.");
        click(loginregister);
        Thread.sleep(5000);
        return new LoginPage(driver);
    }
    
    
}
