package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import pages.BasePage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
	public static String fileName;


    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setEncoding("utf-8");
        reporter.config().setReportName("Sample Extent Report");
        
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "SW Test Academy");
        extentReports.setSystemInfo("Author", "Onur Baskirt");
        return extentReports;
    }
    
    public static void captureScreenshot() throws IOException {
		
		Date d = new Date();
		 fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

		
		
		File screeshot = ((TakesScreenshot)  BasePage.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screeshot, new File(".//reports//"+fileName));
	}
	
	

	public static void captureElementScreenshot(WebElement element) throws IOException {
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

		
		
		File screeshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screeshot, new File(".//screenshot//"+"Element_"+fileName));
	}
}
