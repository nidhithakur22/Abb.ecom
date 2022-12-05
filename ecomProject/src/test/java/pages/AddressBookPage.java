package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Log;

public class AddressBookPage extends BasePage{

	public AddressBookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 
	/**
     * Web Elements
     */
	
	By addnewaddress     = By.xpath("//*[@id=\"maincontent\"]/div/div[3]/div[4]/div[1]/button");
	By postalcode        = By.xpath("//*[@id=\"zip\"]");
	By addressline1      = By.xpath("//*[@id=\"street_0\"]");
	By city              = By.xpath("//*[@id=\"city\"]");
	By defaultbutton     = By.xpath("//*[@id=\"primary_billing\"]");
	By savebutton        = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
	By defaultbut        = By.xpath("//*[@id=\"primary_shipping\"]");
	
	
	/**
     * Page Methods
     * @throws InterruptedException 
     */
	
public AddressBookPage newBillingaddress ()throws InterruptedException {
		
		Log.info("Adding new billingaddress");
	
	Thread.sleep(4000);
	 WebElement scroll = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div[3]/div[4]/div[1]/button")); 
     System.out.println("lable is detected");
     Thread.sleep(6000);
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
	Thread.sleep(4000);
	click(addnewaddress);
	Thread.sleep(4000);
	writeText(postalcode," 110034");
	Thread.sleep(5000);
	writeText(addressline1,"no 10 appt delhi");
	Thread.sleep(4000);
	 WebElement scroll1 = driver.findElement(By.xpath("//*[@id=\"city\"]")); 
     System.out.println("lable is detected");
     Thread.sleep(4000);
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scroll1);
	writeText(city  , "Delhi");
	Thread.sleep(4000);
	click(defaultbutton);
	Thread.sleep(4000);
	click(savebutton);
		
	return new AddressBookPage (driver) ;
	
}
public AddressBookPage newShippingaddress ()throws InterruptedException {
	
	
	
	Thread.sleep(4000);
	 WebElement scroll = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div[3]/div[4]/div[1]/button")); 
    System.out.println("lable is detected");
    Thread.sleep(6000);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
	Thread.sleep(4000);
	click(addnewaddress);
	Thread.sleep(4000);
	writeText(postalcode," 110089");
	Thread.sleep(5000);
	writeText(addressline1,"no 15 appt delhi");
	Thread.sleep(4000);
	 WebElement scroll1 = driver.findElement(By.xpath("//*[@id=\"city\"]")); 
    System.out.println("lable is detected");
    Thread.sleep(4000);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scroll1);
	writeText(city  , "Delhi");
	Thread.sleep(4000);
	click(defaultbut);
	Thread.sleep(4000);
	click(savebutton);
	
	return new AddressBookPage (driver);
	
	
	
}

}
