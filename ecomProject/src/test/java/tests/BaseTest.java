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

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import util.Log;

public class BaseTest {
    public WebDriver driver;
    public LoginPage  loginPage;
    public HomePage homePage;
    public MyAccountPage myaccountPage;
    public WebDriverWait wait;
    public WebDriver getDriver() {
        return driver;
    }
    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\akshi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
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
        
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
       }
    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
      // driver.quit();
    }
}