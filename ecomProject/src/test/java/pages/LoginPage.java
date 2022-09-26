package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.JSErrorLogs;
import util.Log;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class LoginPage extends BasePage {
    /**
     * Constructor
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Web Elements
     */
    
    By userNameId                = By.id("email");
    By passwordId                = By.id("pass");
    By loginButtonId             = By.id("send2");
    By errorMessageUsernameXpath = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordXpath = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");
    By signInButtonClass		 = By.className("btnSignIn");
    
  
    
    /**
     * Variables
     */
    String baseURL = "https://stage.shop.in.abb.com/";
    
    
    /**
     * Page Methods
     * @throws InterruptedException 
     */
    
    //Login to ABB emart
   
    
    public MyAccountPage logintoABBemart(String username, String password) throws InterruptedException {
        Log.info("Trying to login to ABB emart.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        Thread.sleep(2000);
        click(loginButtonId);
        return new MyAccountPage(driver);
    }
    //Verify Username Condition
    public LoginPage verifyLoginUserName(String expectedText) {
        Log.info("Verifying login username.");
        waitVisibility(errorMessageUsernameXpath);
        assertEquals(readText(errorMessageUsernameXpath), expectedText);
        return this;
    }
    //Verify Password Condition
    public LoginPage verifyLoginPassword(String expectedText) {
        Log.info("Verifying login password.");
        waitVisibility(errorMessagePasswordXpath);
        assertEquals(readText(errorMessagePasswordXpath), expectedText);
        return this;
    }
    //Verify Password Condition
    public LoginPage verifyLogError() {
        Log.info("Verifying javascript login errors.");
        assertTrue(JSErrorLogs.isLoginErrorLog(driver));
        return this;
    }
}