
package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import pages.AddNewAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.MyAccountPage;
import pages.MyCartPage;
import pages.MyWishlistPage;
import pages.MyorderPage;
import pages.ProductDescriptionPage;
import util.Log;

public class BaseTest {

	
    public WebDriver driver;
    public LoginPage  loginPage;
    public HomePage homePage;
    public MyAccountPage myaccountPage;
    public ProductDescriptionPage productdescriptionPage;
    public MyCartPage mycartpage;
    public AddNewAccountPage addnewAccountPage;
    public MyorderPage myorderPage;
    public MyWishlistPage mywishlistPage;
    public LogoutPage logoutpage;
    public WebDriverWait wait;
    
    public WebDriver getDriver() {
        return driver;
    }
   
   	
    
    @BeforeClass
    public void classLevelSetup() throws InterruptedException {
        Log.info("Tests is starting!");
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        ChromeOptions option=new ChromeOptions();
        option.setPageLoadStrategy(PageLoadStrategy.NONE);
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage=new HomePage(driver);
        myaccountPage=new MyAccountPage(driver);
        productdescriptionPage = new ProductDescriptionPage(driver);
        mycartpage = new MyCartPage(driver);
        logoutpage = new LogoutPage(driver);
        myaccountPage=new MyAccountPage(driver);
        addnewAccountPage = new AddNewAccountPage(driver);
        myorderPage = new MyorderPage (driver);
        mywishlistPage = new MyWishlistPage (driver);
        String emailidinput="smith.test1@yopmail.com";
    	String password="smith@123";
    	homePage
    		.openABBemart()
    		.loginABBemart();
        loginPage.logintoABBemart(emailidinput, password);
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    }
    
    @BeforeMethod
    public void methodLevelSetup1() {
            }
        
    
	
	  @AfterMethod public void methodLevelSetup() throws InterruptedException {
		 
	    
	  
	  }
	 
	 
	  
    @AfterClass
    public void teardown() {
    	
        Log.info("Tests are ending!");
      // driver.quit();
    }
    
   
 
 
}