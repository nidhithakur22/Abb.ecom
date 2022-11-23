package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyorderPage extends BasePage{

	public MyorderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 public String OrderId;
	 
	 
	By Order   = By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[2]/td[2]");
	
	public MyorderPage MyordersVerify () throws Exception {
//    
    List<WebElement> list = driver.findElements(Order);
    
     System.out.println("hello");
   // System.out.println(list.size());
    for(WebElement lsElement : list)
   	 
    { OrderId = lsElement.getText();
    Thread.sleep(5000);
    System.out.println(OrderId);
    System.out.println("hello");
    }
	return new MyorderPage(driver) ;
	}


}
