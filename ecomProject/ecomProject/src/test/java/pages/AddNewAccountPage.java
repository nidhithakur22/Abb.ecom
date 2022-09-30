package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Log;

public class AddNewAccountPage extends BasePage {

	public AddNewAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
     * Web Elements
     */
	
	By  prefix            = By.xpath("//*[@id=\"prefix\"]"); //*[@id="prefix"]
	By  Mr                = By.xpath("//*[@id=\"prefix\"]/option[2]");
	By firstname          = By.xpath("//*[@id=\"firstname\"]");
	By lastname           = By.xpath("//*[@id=\"lastname\"]");
	By Email              = By.xpath("//*[@id=\"email_address\"]");
	By password           = By.xpath("//*[@id=\"password\"]");
	By passwordconfirmation    = By.xpath("//*[@id=\"password-confirmation\"]");
	By Mobile             = By.xpath("//*[@id=\"mobile\"]");
	By occupation         = By.xpath("//*[@id=\"occupation\"]");
	By builder            = By.xpath("//*[@id=\"occupation\"]/option[4]");
	By agree              = By.xpath("//*[@id=\"is_subscribed-end\"]");
	By agree2             = By.xpath("//*[@id=\"terms-end\"]");
	By submit             = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");

	
	 /**
     * Page Methods
     * @throws InterruptedException 
     */
	
	public AddNewAccountPage addnewcustomer ()throws InterruptedException {
		
		Log.info("Adding new customer");
		
		Thread.sleep(4000);
		click(prefix);
		Thread.sleep(3000);
		click(Mr);
		Thread.sleep(3000);
		writeText(firstname, "qwerty");
		Thread.sleep(4000);
		writeText(lastname, "abc");
		Thread.sleep(3000);
		writeText(Email, "test123@yopmail.com");
		Thread.sleep(3000);
		writeText(password, "testinG@098");
		Thread.sleep(6000);
		 WebElement scroll = driver.findElement(By.xpath("//*[@id=\"password\"]")); 
         System.out.println("lable is detected");
         Thread.sleep(6000);
         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
         //scroll.sendKeys(Keys.PAGE_DOWN);
         System.out.println("scroll is executed successfully2");
		Thread.sleep(4000);
		writeText(passwordconfirmation,"testinG@098");
		Thread.sleep(3000);
		writeText(Mobile, "9999999999");
		Thread.sleep(9000);
		// WebElement scroll1 = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")); 
         //System.out.println("lable is detected");
        // ((JavascriptExecutor)driver).executeScript("arguments[0];", scroll1);
         Thread.sleep(4000);
		click(occupation);
		Thread.sleep(5000);
		click(builder);
		Thread.sleep(3000);
		click(agree);
		click(agree2);
		Thread.sleep(5000);
		click(submit);
		
		return this ;
		
	}
}
