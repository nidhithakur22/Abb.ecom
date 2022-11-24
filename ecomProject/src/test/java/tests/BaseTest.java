
package tests;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import com.test.Utility.*;

import pages.AddNewAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyWishlistPage;
import pages.MyorderPage;
import util.Log;

public class BaseTest {
    public WebDriver driver;
    public LoginPage  loginPage;
    public HomePage homePage;
    public MyAccountPage myaccountPage;
    public AddNewAccountPage addnewAccountPage;
    public MyorderPage myorderPage;
    public MyWishlistPage mywishlistPage;
    public WebDriverWait wait;
   // public TestUtil testUtil;
    public WebDriver getDriver() {
        return driver;
    }
    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        ChromeOptions option=new ChromeOptions();
        option.setPageLoadStrategy(PageLoadStrategy.NONE);
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        
    }
    @BeforeMethod
    public void methodLevelSetup() {
        loginPage = new LoginPage(driver);
        homePage=new HomePage(driver);
        myaccountPage=new MyAccountPage(driver);
        addnewAccountPage = new AddNewAccountPage(driver);
        myorderPage = new MyorderPage (driver);
        mywishlistPage = new MyWishlistPage (driver);
        
        
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
       }
    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
      // driver.quit();
    }
}